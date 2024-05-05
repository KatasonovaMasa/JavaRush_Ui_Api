package ui.steps;

import io.qameta.allure.Step;
import ui.pages.CreateACoursePage;
import ui.pages.StartPage;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;

public class CreatACourseStep {

    StartPage startPage = new StartPage();
    CreateACoursePage createACoursePage = new CreateACoursePage();

    @Step("Нажать на 'Начать'")
    public void pressStartButton() {
        createACoursePage.startLearning.shouldBe(visible.because("кнопка 'Начать' не видна")).click();
    }

    @Step("Выбрать русский язык")
    public void selectLanguage() {
        createACoursePage.selectLanguage.shouldBe(visible.because("Не видна кнопка выбора языка")).click();
    }

    @Step("Ввести email и password")
    public void inputEmail(String email) {
        createACoursePage.email.setValue(email);
    }

    @Step("Ввести password")
    public void inputPassword(String password) {
        createACoursePage.password.setValue(password);
    }

    @Step("Нажать на 'Создать аккаунт'")
    public void clickCreatAccount() {
        createACoursePage.creatAccount.shouldBe(visible.because("Не видна кнопка 'Создать аккаунт'")).click();
    }

    @Step("Проверить, что аккаунт создался")
    public void checkCreatAccount() {
        createACoursePage.checkCreatAccount.shouldBe(hidden.because("Аккаунт не создаётся"));
    }

    @Step("Удалить аккаунт")
    public void clickDeletedAccount(String deleted) {
        createACoursePage.securityAndEntry.shouldBe(visible.because("Не видна вкладка 'Безопасность и вход'")).click();
        startPage.openYouTube.scrollTo();
        createACoursePage.textMobile.click();
        createACoursePage.iconDeletedAccount.shouldBe(visible.because("Не нажали на надпись 'Удаления аккаунта'")).click();
        createACoursePage.inputDeletedAccount.shouldBe(visible.because("Не появилось окно подтверждения удаления аккаунта")).setValue(deleted);
        createACoursePage.buttonDeletedAccount.shouldBe(visible.because("Не видна кнопка 'Удалить'")).click();
        createACoursePage.checkDeletedAccount.shouldBe(visible.because("Аккаунт не удалился"));
    }
}
