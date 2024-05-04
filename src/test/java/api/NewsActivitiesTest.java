package api;

import api.models.NewsActivities;
import api.rest.PostNewsActivities;
import api.specs.Specification;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Optional;

import static config.ExpectedDataEnum.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;


@Tag("JRApi")
@Owner("Катасонова Мария")
@Feature("Автотесты для API")
@Story("Раздел 'Активности' ")
@DisplayName("Получение Активностей пользователей")
public class NewsActivitiesTest {

    @Test
    @DisplayName("Получение активностей пользователя")
    void checkReceiptOfUserActivities() {
        NewsActivities[] data = given()
                .spec(Specification.news)
                .when()
                .get("/")
                .then()
                .log().body()
                .spec(Specification.responseSpec)
                .extract().as(NewsActivities[].class);
        NewsActivities actualNewsActivities = Arrays.stream(data)
                .filter(newsActivities -> newsActivities.getUser().getKey().contains(EXPECTED_KEY_NEWS.getValue()))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Не нашли подходящий объект"));
        String actualUserId = String.valueOf(actualNewsActivities.getUser().getUserId());

        assertThat(data.length).isEqualTo(100);
        assertThat(actualUserId).contains(EXPECTED_USER_ID_NEWS.getValue()); // Проверка на частичное совпадение userId
    }

    @Test
    @DisplayName("Получение активностей пользователей через цикл, который перебирает объекты в массиве")
    void checkRetrievingUserActivitiesThroughALoopThatIteratesThroughObjectsInAnArray() {
        NewsActivities[] data = given()
                .spec(Specification.news)
                .when()
                .get("/")
                .then()
                .log().body()
                .spec(Specification.responseSpec)
                .extract().as(NewsActivities[].class);
        Optional<NewsActivities> found = Optional.empty();
        for (NewsActivities newsActivities : data) {
            if (newsActivities.getType().contains(EXPECTED_TYPE_NEWS.getValue())) {
                found = Optional.of(newsActivities);
                break;
            }
        }

        NewsActivities actualNewsActivities = found.orElseThrow(() ->
                new IllegalArgumentException(String.format("Элемент с id = %d не найден", EXPECTED_ID_NEWS.getValue())));
        String actualId = String.valueOf(actualNewsActivities.getId());

        assertThat(data.length).isEqualTo(100);
        assertThat(actualNewsActivities.getDescription()).contains(EXPECTED_DESCRIPTION_NEWS.getValue());// Проверка на частичное совпадение description
        assertThat(actualId).contains(EXPECTED_ID_NEWS.getValue()); // Проверка на частичное совпадение id
    }

    @Test
    @DisplayName("Получение активностей пользователей через stream")
    void checkReceivingUserActivitiesViaStream() {
        NewsActivities[] data = given()
                .spec(Specification.news)
                .when()
                .get("/")
                .then()
                .log().body()
                .spec(Specification.responseSpec)
                .extract().as(NewsActivities[].class);
        NewsActivities actualNewsActivities = Arrays.stream(data)
                .filter(newsActivities -> newsActivities.getType().contains(EXPECTED_TYPE_NEWS.getValue()))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Не нашли подходящий объект"));
        String actualId = String.valueOf(actualNewsActivities.getId());

        LocalDateTime actualTime = LocalDateTime.ofInstant(
                Instant.ofEpochMilli(actualNewsActivities.getTime()),
                ZoneOffset.systemDefault()
        );

        assertThat(data.length).isEqualTo(100);
        assertThat(actualId).contains(EXPECTED_ID_NEWS.getValue()); // Проверка на частичное совпадение id
        assertThat(actualTime.getYear()).isEqualTo(2024);
    }

    @Test
    @DisplayName("Проверка json схемы 'Активностей пользователей' ")
    void checkTheUserActivitiesJsonSchema() {
                PostNewsActivities.getPostNewsActivities()
                .then()
                .spec(Specification.responseSpec)
                .body(matchesJsonSchemaInClasspath("schemes/news.json"));
    }
}
