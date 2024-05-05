package ui.steps;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import ui.pages.SectionsInTheApplicationPage;

import static com.codeborne.selenide.Condition.text;

public class SectionsInTheApplicationStep {

    SectionsInTheApplicationPage sectionsInTheApplicationPage = new SectionsInTheApplicationPage();

    @Step("Проверить, что открылась нужная страница")
    public void checkMenuPage(String typeElement) {
        WebDriverRunner.getWebDriver().manage().window().fullscreen();
        sectionsInTheApplicationPage.checkMenuTabType(typeElement).shouldHave(text(typeElement));
    }
}