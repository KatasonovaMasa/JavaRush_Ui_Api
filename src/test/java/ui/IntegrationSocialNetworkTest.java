package ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

@Tag("JRUI")
@Owner("Катасонова Мария")
@Feature("Автотесты для UI")
@Story("Интеграция c соцсетями")
@DisplayName("Интеграция c соцсетями")
@TestMethodOrder(MethodOrderer.MethodName.class)
public class IntegrationSocialNetworkTest extends TestBase {

    @Test
    @DisplayName("Интеграция с Телеграмм")
    public void integrationTelegram() {
        startStep.openJavaRush();
        startStep.closeCookie();
        integrationSocialNetworkStep.scrollDownPage();
        integrationSocialNetworkStep.openTelegramIcon();
        integrationSocialNetworkStep.openPageTelegram();
        integrationSocialNetworkStep.checkTelegramPage();
        integrationSocialNetworkStep.closePage();
    }

    @Test
    @DisplayName("Интеграция с YouTube")
    public void integrationYouTube() {
        startStep.openJavaRush();
        startStep.closeCookie();
        integrationSocialNetworkStep.scrollDownPage();
        integrationSocialNetworkStep.openYouTubeIcon();
        integrationSocialNetworkStep.openPageYouTube();
        integrationSocialNetworkStep.acceptYouTube();
        integrationSocialNetworkStep.checkYouTubePage();
    }
}
