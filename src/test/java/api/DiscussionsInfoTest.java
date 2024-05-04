package api;

import api.models.DiscussionsComments;
import api.models.DiscussionsInfo;
import api.models.DiscussionsLikes;
import api.rest.PostDiscussions;
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
@Feature("Автотесты для API")
@Story("Раздел 'Отзывы' ")
@Owner("Катасонова Мария")
@DisplayName("Раздел 'Отзывы' ")
public class DiscussionsInfoTest {

    @Test
    @DisplayName("Получение количества лайков под отзывом")
    void checkDiscussionsLikes() {
        DiscussionsLikes data = given()
                .spec(Specification.discussions)
                .when()
                .get("/article30")
                .then()
                .log().body()
                .spec(Specification.responseSpec)
                .extract().as(DiscussionsLikes.class);

        Assertions.assertEquals(EXPECTED_COUNT.getValue(), data.getLikes().getCount());
        assertThat(data.getId()).isEqualTo(EXPECTED_ID_DISCUSSIONS.getValue());
    }

    @Test
    @DisplayName("Получение комментария под отзывом")
    void checkDiscussionsComments() {
        DiscussionsComments data =
                given()
                .spec(Specification.discussions)
                .when()
                .get("/discussion8/comments/932598")
                .then()
                .log().body()
                .spec(Specification.responseSpec)
                .extract().as(DiscussionsComments.class);

        Assertions.assertEquals(EXPECTED_ID_COMMENTS.getValue(), data.getId());
        Assertions.assertEquals(EXPECTED_OWNER_COMMENTS.getValue(), data.getOwner().level);
        assertThat(data.getMessage()).isEqualTo(EXPECTED_DISCUSSIONS_MESSAGE.getValue());
        assertThat(data.getOwner().getKey()).isEqualTo(EXPECTED_OWNER_COMMENT.getValue());
    }

    @Test
    @DisplayName("Получение информации об отзыве")
    void checkDiscussionsInfo() {
        DiscussionsInfo data = given()
                .spec(Specification.request)
                .when()
                .get("/markup/discussions/13")
                .then()
                .log().body()
                .spec(Specification.responseSpec)
                .extract().as(DiscussionsInfo.class);

        Assertions.assertEquals(EXPECTED_ID_DISCUSSIONS.getValue(), data.getDiscussionId());
        assertThat(data.getDiscussionType()).isEqualTo(EXPECTED_DISCUSSIONS_TYPE.getValue());
    }

    @Test
    @DisplayName("Проверка json схемы по количеству лайков под отзывом")
    void checkTheJsonSchemeByTheNumberOfLikesUnderAReview() {
        PostDiscussions.getPostDiscussions()
                .then()
                .spec(Specification.responseSpec)
                .body(matchesJsonSchemaInClasspath("schemes/like.json"));
    }
}
