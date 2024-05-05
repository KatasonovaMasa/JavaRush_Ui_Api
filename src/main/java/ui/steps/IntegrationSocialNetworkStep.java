package ui.steps;

import io.qameta.allure.Step;
import ui.pages.IntegrationSocialNetworkPage;
import ui.pages.StartPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.switchTo;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class IntegrationSocialNetworkStep {

    IntegrationSocialNetworkPage integrationSocialNetworkPage = new IntegrationSocialNetworkPage();
    StartPage startPage = new StartPage();

    @Step("Проскролить вниз страницы ")
    public void scrollDownPage() {
        startPage.downloadButton.scrollIntoView(true);
    }

    @Step("Нажать на иконку YouTube")
    public void openYouTubeIcon() {
        startPage.openYouTube.shouldBe(visible.because("Не видна иконка YouTube")).click();
    }

    @Step("Перейти на другую вкладку")
    public void openPageYouTube() {
        switchTo().window(1);
    }

    @Step("Принять правила YouTube")
    public void acceptYouTube() {
        if (integrationSocialNetworkPage.acceptYouTube.has(visible)) {
            integrationSocialNetworkPage.acceptYouTube.shouldBe(visible.because("Не появились правила YouTube")).click();
        }
    }

    @Step("Проверка перехода в канал YouTube - JavaRush")
    public void checkYouTubePage() {
        assertThat(getWebDriver().getTitle()).isEqualTo("JavaRush - YouTube");
    }

    @Step("Нажать на иконку Telegram")
    public void openTelegramIcon() {
        startPage.openTelegram.shouldBe(visible.because("Не видна иконка Telegram")).click();
    }

    @Step("Перейти на другую вкладку")
    public void openPageTelegram() {
        switchTo().window(1);
    }

    @Step("Проверка перехода в канал Телеграмм - JavaRush")
    public void checkTelegramPage() {
        integrationSocialNetworkPage.telegramChannel.shouldHave(text("JavaRush").because("Не перешли на JavaRush канал в Телеграмм"));
    }

    @Step("Закрытие вкладки")
    public void closePage() {
        closeWindow();
        switchTo().window(0);
    }
}
