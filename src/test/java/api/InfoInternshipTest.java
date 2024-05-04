package api;

import api.models.InternshipInfo;
import api.rest.PostUser;
import api.specs.Specification;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static config.ExpectedData.*;
import static config.ExpectedDataEnum.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("JRApi")
@Owner("Катасонова Мария")
@Feature("Автотесты для API")
@Story("Раздел 'Стажировка' ")
@DisplayName("Раздел 'Стажировка' ")
public class InfoInternshipTest {

    @Test
    @DisplayName("Получение информации по пользователю о стажировке")
    void checkUsersInfoInternship() {
        InternshipInfo data = given()
                .spec(Specification.internship)
                .when()
                .get("/articlecom.javarush.article.about.internship")
                .then()
                .log().body()
                .spec(Specification.responseSpec)
                .extract().as(InternshipInfo.class);

        Assertions.assertEquals(EXPECTED_ID_INTERNSHIP.getValue(), data.getId());
        assertThat(data.getTitle()).isEqualTo(EXPECTED_TITLE_INFO_INTERNSHIP.getValue());
        Assertions.assertEquals(EXPECTED_USER_ID_INTERNSHIP.getValue(), data.getUser().getUserId());
        assertThat(data.getUser().getDisplayName()).isEqualTo(EXPECTED_DISPLAY_NAME.getValue());
    }

    @Test
    @DisplayName("Получение информации по пользователю о собеседовании")
    void checkInfoForClientOrInterview() {
        InternshipInfo data = given()
                .spec(Specification.internship)
                .when()
                .get("/articlecom.javarush.article.about.questions.for.interview")
                .then()
                .log().body()
                .spec(Specification.responseSpec)
                .extract().as(InternshipInfo.class);

        Assertions.assertEquals(EXPECTED_ID_INTERVIEW.getValue(), data.getId());
        assertThat(data.getTitle()).isEqualTo(EXPECTED_TITLE_INTERVIEW.getValue());
    }

    @Test
    @DisplayName("Проверка json схемы информации по пользователям о собеседованиях")
    void checkTheUserActivitiesJsonSchema() {
                PostUser.getUserActivities()
                .then()
                .spec(Specification.responseSpec)
                .body(matchesJsonSchemaInClasspath("schemes/internship.json"));
    }
}