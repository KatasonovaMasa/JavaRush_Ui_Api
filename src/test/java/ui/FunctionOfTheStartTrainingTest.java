package ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("JRUI")
@Owner("Катасонова Мария")
@Feature("Автотесты для UI")
@Story("Кнопка 'Начать обучение' в 2-х варинтах")
@DisplayName("Кнопка 'Начать обучение' в 2-х варинтах")
public class FunctionOfTheStartTrainingTest extends TestBase {

    @Test
    @DisplayName("Кнопка 'Начать обучение' в меню/в конце страницы")
    void functionOfTheStartTrainingButtonsInTheMenuAtTheEndOfThePage() {
        startStep.openJavaRush();
        startStep.startLearnOne();
        functionOfTheStartTrainingStep.checkThisIsWhereTheyBecomeJavaProgrammers();
        startStep.openJavaRush();
        integrationSocialNetworkStep.scrollDownPage();
        startStep.closeCookie();
        startStep.startLearningTwo();
        functionOfTheStartTrainingStep.checkThisIsWhereTheyBecomeJavaProgrammers();
    }
}
