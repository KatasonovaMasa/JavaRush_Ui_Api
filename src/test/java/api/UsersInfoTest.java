package api;

import api.models.Users;
import api.rest.PostUser;
import api.specs.Specification;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static config.ExpectedData.*;
import static config.ExpectedDataEnum.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("JRApi")
@Owner("Катасонова Мария")
@Feature("Автотесты для API")
@Story("Раздел 'Пользователи'")
@DisplayName("Раздел 'Пользователи'")
public class UsersInfoTest {

    @Test
    @DisplayName("Получение информации по пользователю")
    void checkUsersOne() {
        Users data = given()
                .spec(Specification.users)
                .when()
                .get("/user2209041")
                .then()
                .log().body()
                .spec(Specification.responseSpec)
                .extract().as(Users.class);

        assertThat(data.getUserId()).isEqualTo(EXPECTED_USER_ID_ONE.getValue());
        Assertions.assertEquals(EXPECTED_USER_CITY.getValue(), data.getCity());
        Assertions.assertEquals(EXPECTED_POSITION_QA.getValue(), data.getPosition());
    }

    @Test
    @DisplayName("Получение информации по пользователю")
    void checkUsersTwo() {
        Users data = given()
                .spec(Specification.users)
                .when()
                .get("/user3320682")
                .then()
                .log().body()
                .spec(Specification.responseSpec)
                .extract().as(Users.class);

        assertThat(data.getUserId()).isEqualTo(EXPECTED_USER_ID_TWO.getValue());
        Assertions.assertEquals(EXPECTED_USER_DISPLAY_NAME.getValue(), data.getDisplayName());
        Assertions.assertEquals(EXPECTED_POSITION_QA.getValue(), data.getPosition());
    }

    @Test
    @DisplayName("Получение информации по пользователю")
    void checkUsersThree() {
        Users data = given()
                .spec(Specification.users)
                .when()
                .get("/user3180543")
                .then()
                .log().body()
                .spec(Specification.responseSpec)
                .extract().as(Users.class);

        assertThat(data.getUserId()).isEqualTo(EXPECTED_USER_ID_THREE.getValue());
        Assertions.assertEquals(EXPECTED_USER_NAME.getValue(), data.getDisplayName());
        Assertions.assertEquals(EXPECTED_POSITION_BACK.getValue(), data.getPosition());
    }

    @Test
    @DisplayName("Получение информации из списка всех пользователей")
    void checkUsersFour() {
        Users[] data = given()
                .spec(Specification.users)
                .when()
                .get("?filter=ALL")
                .then()
                .log().body()
                .spec(Specification.responseSpec)
                .extract().as(Users[].class);
        Users actualUsers = Arrays.stream(data)
                .filter(user -> user.getPictureUrl().contains(EXPECTED_PICTURE_URL_USERS.getValue()))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Не нашли подходящий объект"));
        String actualKey = String.valueOf(actualUsers.getKey());

        assertThat(actualKey).contains(EXPECTED_KEY_USERS.getValue());
    }

    @Test
    @DisplayName("Проверка json схемы всех пользователей")
    void checkAllUsersJsonSchema() {
                PostUser.getPostUser()
                .then()
                .spec(Specification.responseSpec)
                .body(matchesJsonSchemaInClasspath("schemes/users.json"));
    }
}


