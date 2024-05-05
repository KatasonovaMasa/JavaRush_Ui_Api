package ui.steps;

import io.qameta.allure.Step;
import ui.pages.FunctionOfTheStartTrainingPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.switchTo;

public class FunctionOfTheStartTrainingStep {

    FunctionOfTheStartTrainingPage functionOfTheStartTrainPage = new FunctionOfTheStartTrainingPage();

    @Step("Проверить, что курс создался")
    public void checkThisIsWhereTheyBecomeJavaProgrammers() {
        switchTo().window(1);
        functionOfTheStartTrainPage.checkThisIsWhereTheyBecomeJavaProgrammers.shouldHave(text("Здесь становятся Java‑программистами").because("Не отображается варианты создания аккаунта")).click();
        switchTo().window(0);
    }
}
