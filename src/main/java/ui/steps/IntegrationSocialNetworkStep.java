package ui.steps;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import ui.pages.IntegrationSocialNetworkPage;
import ui.pages.StartPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.switchTo;

public class IntegrationSocialNetworkStep {

    IntegrationSocialNetworkPage integrationSocialNetworkPage = new IntegrationSocialNetworkPage();
    StartPage startPage = new StartPage();


    @Step("Проскролить вниз страницы ")
    public void scrollDownPage() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        startPage.downloadButton.scrollIntoView(true);
    }

    @Step("Нажать на иконку YouTube")
    public void openYouTubeIcon() {
        startPage.openYouTube.click();
    }

    @Step("Перейти на другую вкладку")
    public void openPageYouTube() {
        switchTo().window(1);
    }

    @Step("Принять правила YouTube")
    public void acceptYouTube() {
        if (integrationSocialNetworkPage.acceptYouTube.has(visible)) {
            integrationSocialNetworkPage.acceptYouTube.click();
        }
    }

    @Step("Проверка перехода в канал YouTube - JavaRush")
    public void checkYouTubePage() {
        integrationSocialNetworkPage.youTubeChannel.shouldHave(text("JavaRush").because("Не перешли на JavaRush канал в YouTube"));
    }

    @Step("Нажать на иконку Telegram")
    public void openTelegramIcon() {
        startPage.openTelegram.click();
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
