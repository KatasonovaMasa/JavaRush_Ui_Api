package ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static help.GenerateRandomPage.generateRockStarText;

@Tag("JRUIY")
@Owner("Катасонова Мария")
@Feature("Автотесты для UI")
@Story("Создание аккаунта")
@DisplayName("Создание рандомного аккаунта")
@TestMethodOrder(MethodOrderer.MethodName.class)
public class CreatAccountTest extends TestBase {

    String deleted = "DELETE";

    @Test
    @DisplayName("Создание и удаление аккаунта")
    void createdAccount() {
        startStep.openJavaRush();
        startStep.startLearnOne();
        creatACourseStep.pressStartButton();
        creatACourseStep.selectLanguage();
        String expectedEmail = generateRockStarText();
        creatACourseStep.inputEmail(expectedEmail + "@mail.ru");
        String expectedPassword = generateRockStarText();
        creatACourseStep.inputPassword(expectedPassword);
        creatACourseStep.clickCreatAccount();
        creatACourseStep.checkCreatAccount();
        sidebarStep.scrollDownSettings();
        sidebarStep.openSettings();
        creatACourseStep.clickDeletedAccount(deleted);
    }
}