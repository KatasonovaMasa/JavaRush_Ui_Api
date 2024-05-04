package api;

import api.models.Games;
import api.models.ProjectsInfo;
import api.rest.PostGames;
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
import static config.GameEnum.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("JRApi")
@Feature("Автотесты для API")
@Story("Раздел 'Игры' ")
@Owner("Катасонова Мария")
@DisplayName("Раздел 'Игры' ")
public class GamesInfoTest {

    @Test
    @DisplayName("Информация по игре 'Сапер' ")
    void checkInfoGameMinesweeper() {
        ProjectsInfo data = given()
                .spec(Specification.games)
                .when()
                .get("/projectcom.javarush.games.minesweeper")
                .then()
                .log().body()
                .spec(Specification.responseSpec)
                .extract().as(ProjectsInfo.class);

        assertThat(data.getId()).isEqualTo(EXPECTED_ID_MINESWEEPER.getValue());
        Assertions.assertEquals(EXPECTED_DESCRIPTION_MINESWEEPER.getValue(), data.getDescription());
        Assertions.assertEquals(EXPECTED_TASKS_TOTAL_MINESWEEPER.getValue(), data.getTasksTotal());
    }

    @Test
    @DisplayName("Информация по игре 'Змейка' ")
    void checkInfoGameSnake() {
        ProjectsInfo data = given()
                .spec(Specification.games)
                .when()
                .get("/projectcom.javarush.games.snake")
                .then()
                .log().body()
                .spec(Specification.responseSpec)
                .extract().as(ProjectsInfo.class);

        assertThat(data.getId()).isEqualTo(EXPECTED_ID_SNAKE.getValue());
        Assertions.assertEquals(EXPECTED_DESCRIPTION_SNAKE.getValue(), data.getDescription());
        Assertions.assertEquals(EXPECTED_TASKS_TOTAL_SNAKE.getValue(), data.getTasksTotal());
    }

    @Test
    @DisplayName("Информация по игре 'Moon Lander' ")
    void checkInfoGameMoonLander() {
        ProjectsInfo data = given()
                .spec(Specification.games)
                .when()
                .get("/projectcom.javarush.games.moonlander")
                .then()
                .log().body()
                .spec(Specification.responseSpec)
                .extract().as(ProjectsInfo.class);

        assertThat(data.getId()).isEqualTo(4);
        Assertions.assertEquals(EXPECTED_DESCRIPTION_MOON_LANDER.getValue(), data.getDescription());
        Assertions.assertEquals(EXPECTED_ID_MOON_LANDER.getValue(), data.getTasksTotal());
    }

    @Test
    @DisplayName("Получение информации по играм на JavaRush")
    void checkGettingInfoAboutGamesOnJavaRush() {
        Games[] data = given()
                .spec(Specification.games)
                .when()
                .get("/")
                .then()
                .log().body()
                .spec(Specification.responseSpec)
                .extract().as(Games[].class);

        Games actualGames = Arrays.stream(data)
                .filter(games -> games.getDescription().contains(EXPECTED_DESCRIPTION_SNAKE.getValue()))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Не нашли подходящий объект"));

        assertThat(actualGames.getAppId()).isNull(); // проверка у Object
        assertThat(actualGames.getId()).isEqualTo(EXPECTED_ID_All.getValue());
        assertThat(actualGames.getContent()).contains(EXPECTED_CONTENT_GAMES.getValue());
    }

    @Test
    @DisplayName("Проверка json схемы игр на javaRush")
    void checkGamesJsonSchema() {
                PostGames.getPostGames()
                .then()
                .spec(Specification.responseSpec)
                .body(matchesJsonSchemaInClasspath("schemes/projects.json"));
    }
}
