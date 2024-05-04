package ui.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import help.GenerateRandomPage;
import io.qameta.allure.Step;
import ui.pages.CreateACoursePage;
import ui.pages.StartPage;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;

public class CreatACourseStep {

    StartPage startPage = new StartPage();
    CreateACoursePage createACoursePage = new CreateACoursePage();

    @Step("Прохождение вопросов для получения курса")
    public void cycleOfQuestions() {
        createACoursePage.oneRadioButton.shouldBe((visible).because("Первый radioButton не виден"));
        if (createACoursePage.radioButton.size() > 1 && createACoursePage.unitRadioButton.has(visible)) {
            int count = createACoursePage.list.size();
            for (int i = 0; i < count; i++) {
                sleep(1000);
                Configuration.pageLoadStrategy = "eager";
                createACoursePage.unitRadioButton.shouldBe((visible).because("Блок radioButtons не виден"));
                createACoursePage.radioButton.get(GenerateRandomPage.generateRandomNumber()).shouldBe((visible).because("Список radioButtons не виден")).click();
                createACoursePage.nextButton.click();
            }
        }
    }

    @Step("Нажать на 'Начать'")
    public void pressStartButton() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        sleep(4000);
        createACoursePage.startLearning.click();
    }

    @Step("Выбрать русский язык")
    public void selectLanguage() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        createACoursePage.selectLanguage.shouldBe(visible.because("Не видна кнопка выбора языка")).click();
    }

    @Step("Ввести email и password")
    public void inputEmail(String email){
        createACoursePage.email.setValue(email);
    }

    @Step("Ввести password")
    public void inputPassword(String password){
        createACoursePage.password.setValue(password);
    }

    @Step("Нажать на 'Создать аккаунт'")
    public void clickCreatAccount(){
        createACoursePage.creatAccount.click();
    }

    @Step("Проверить, что аккаунт создался")
    public void checkCreatAccount() {
        createACoursePage.checkCreatAccount.shouldBe(hidden.because("Аккаунт не создаётся"));
    }
    @Step("Удалить аккаунт")
    public void clickDeletedAccount(String deleted) {
        createACoursePage.securityAndEntry.shouldBe(visible.because("Не видна вкладка 'Безопасность и вход'")).click();
        startPage.openTelegram.scrollTo();
        createACoursePage.textDeletedAccount.scrollTo();
        sleep(10000);
        createACoursePage.textDeletedAccount.shouldBe(visible.because("Не видна надпись удаления аккаунта")).click();
        createACoursePage.inputDeletedAccount.shouldBe(visible.because("Не появилось окно подтверждения удаления аккаунта")).setValue(deleted);
        createACoursePage.buttonDeletedAccount.shouldBe(visible.because("Не видна кнопка 'Удалить'")).click();
        createACoursePage.checkDeletedAccount.shouldBe(visible.because("Аккаунт не удалился"));
    }
    @Step("Выбрать профессию 'Инженером тестирования'")
    public void chooseQa() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        createACoursePage.chooseQa.shouldBe(visible.because("Не видна кнопка выбора профессии")).click();
    }

    @Step("Прокурутить до нужного элементы и " +
            "Выбрать черную тему")
    public void chooseTheme() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        createACoursePage.chooseTheme.scrollTo();
        createACoursePage.chooseTheme.shouldBe(visible.because("Не видна кнопка выбора темы")).click();
    }

    @Step("Нажать на 'Не сейчас' ")
    public void pressWelcomeSignUpNot() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        createACoursePage.welcomeSignUpNot.shouldBe(visible.because("Не видна кнопка 'Не сейчас' ")).click();
    }

    @Step("Нажать на 'ДА, Определить мой уровень'")
    public void pressYesExperience() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        createACoursePage.yesExperience.shouldBe(visible.because("Не видна кнопка определения уровня")).click();
    }

    @Step("Нажать на 'НЕТ, Определить мой уровень' ")
    public void pressNotExperience() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        createACoursePage.notExperience.shouldBe(visible.because("Не видна кнопка отмены определения уровня")).click();
    }

    @Step("Нажать на 'Начать'")
    public void pressLevelOfExperience() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        createACoursePage.levelOfExperience.shouldBe((visible).because("Не видна кнопка 'Начать'")).click();
        refresh();
    }

    @Step("Проверить, что курс создался")
    public void checkCreatCourse() {
        sleep(20000);
        createACoursePage.checkCreatCourse.shouldBe(exist).shouldHave(Condition.text("Ваш персональный курс готов").because("Курс не создаётся")).click();
    }
}
