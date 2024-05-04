package ui.steps;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import ui.pages.StartPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class StartStep{

    StartPage startPage = new StartPage();

    @Step("Открываем главную страницу")
    public void openJavaRush() {
        open("/");
        refresh();
        refresh();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @Step("Закрываем куки")
    public void closeCookie() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        if (startPage.closeCookie.isDisplayed()) {
            startPage.closeCookie.click();
        }
    }

    @Step("Нажать на 'Начать обучение' в меню")
    public void startLearnOne() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        if (startPage.startLearningOne.isDisplayed()) {
            startPage.startLearningOne.shouldBe(visible.because("Не видна кнопка 'Начать обучение'")).click();
        }
        switchTo().window(1);
    }

    @Step("Нажать на 'Начать обучение' в конце странице")
    public void startLearningTwo() {
        if (startPage.startLearningOne.isDisplayed()) {
            startPage.startLearningTwo.shouldBe(visible.because("Не видна кнопка 'Начать обучение'")).click();
        }
        switchTo().window(1);
    }
}
