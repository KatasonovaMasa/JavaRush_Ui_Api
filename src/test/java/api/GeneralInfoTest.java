package api;

import api.models.GeneralInfo;
import api.rest.PostGeneralInfo;
import api.specs.Specification;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static config.ExpectedDataEnum.*;
import static config.LanguageEnum.*;
import static config.PaymentSystemEnum.*;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("JRApi")
@Feature("Автотесты для API")
@Story("Раздел 'О нас' ")
@Owner("Катасонова Мария")
@DisplayName("Раздел 'О нас' ")
public class GeneralInfoTest {

    @Test
    @DisplayName("Получение информации о разделе 'О нас' ")
    void checkGeneralInfo() {
        GeneralInfo data = given()
                .spec(Specification.request)
                .when()
                .get("/general/info")
                .then()
                .log().body()
                .spec(Specification.responseSpec)
                .extract().as(GeneralInfo.class);
        ArrayList<String> actualSupportedPaymentSystems = data.getApplication().getSupportedPaymentSystems();
        ArrayList<String> actualSupportedLanguages = data.getApplication().getSupportedLanguages();
        // Здесь выполняется проверка наличия ожидаемых значений в actualDisabledFeatures

        Assertions.assertEquals(EXPECTED_SERVER_NAME.getValue(), data.getApplication().getServerName());
        Assertions.assertEquals(EXPECTED_APPLICATION_ID.getValue(), data.getApplication().getApplicationId());
        assertThat(data.getFirebase().getProjectId()).isEqualTo(EXPECTED_PROJECT_ID.getValue());
        assertThat(actualSupportedLanguages)
                .isEqualTo(List.of(EXPECTED_RUSSIAN.getValue(),
                        EXPECTED_UKRAINIAN.getValue(),
                        EXPECTED_ENGLISH.getValue())); //полная проверка массива
        assertThat(actualSupportedPaymentSystems)
                .contains(EXPECTED_VISA.getValue())
                .contains(EXPECTED_MAESTRO.getValue())
                .doesNotContain(EXPECTED_MIR.getValue()); // пример неприсутствия элемента в массиве
    }

    @Test
    @DisplayName("Проверка json схемы в разделе 'О нас' ")
    void checkGeneralInfoJsonSchema() {
                PostGeneralInfo.getPostGeneralInfo()
                .then()
                .spec(Specification.responseSpec)
                .body(matchesJsonSchemaInClasspath("schemes/discussions.json"));
    }
}

