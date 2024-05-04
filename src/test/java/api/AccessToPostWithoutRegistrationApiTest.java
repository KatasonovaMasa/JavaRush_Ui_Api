package api;

import api.models.PostsApi;
import api.rest.PostService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static config.ExpectedDataEnum.*;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("JRApi")
@Feature("Автотесты для API")
@Story("Раздел 'Статьи' ")
@Owner("Катасонова Мария")
@DisplayName("Раздел 'Статьи'")
public class AccessToPostWithoutRegistrationApiTest {

    @ParameterizedTest
    @DisplayName("Проверка доступа к информации о статье без регистрации")
    @ValueSource(strings = {"23", "24", "100"})
    void checkAccessToPostWithoutRegistrationTest(String filter) throws JsonProcessingException {
        PostsApi data = getPostsFiltered(filter);
        assertThat(data.getCode()).isEqualTo(EXPECTED_CODE.getValue());
        assertThat(data.getRecommendation()).isEqualTo(EXPECTED_RECOMMENDATION.getValue());
    }

    @Step("Получить количество постов по фильтру {filter}")
    public PostsApi getPostsFiltered(String filter) throws JsonProcessingException {
        Response response = PostService.getPostCount(filter);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.getBody().asString(), PostsApi.class);
    }
}
