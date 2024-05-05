package ui.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CreateACoursePage {

    public final SelenideElement startLearning = $x("//button[@id='id_button_jr_welcome_start_learning_1']");
    public final SelenideElement selectLanguage = $x(" //div[contains(text(),'Русский')]");
    public final SelenideElement email = $x("//input[@placeholder='Email']");
    public final SelenideElement password = $x("//input[@placeholder='Пароль']");
    public final SelenideElement creatAccount = $x("//button[@id='id_button_jr_welcome_create_account']");
    public final SelenideElement checkCreatAccount = $x("//div[contains(text(),'Anonymous #')]");
    public final SelenideElement securityAndEntry = $x("//a[contains(text(),'Безопасность и вход')]");
    public final SelenideElement iconDeletedAccount = $x("//div[@class='security__last-activity']//div[3]//div[1][1]//jr-icon[1]//*[name()='svg']");
    public final SelenideElement textMobile = $x("//label[contains(text(),'Мобильный телефон')]");
    public final SelenideElement inputDeletedAccount = $x("//input[@type='text']");
    public final SelenideElement buttonDeletedAccount = $x("//button[contains(text(),'Удалить')]");
    public final SelenideElement checkDeletedAccount = $x("//span[contains(text(),'Начать обучение')]");

    public final ElementsCollection list = $$x("//*[contains(@class, 'progress-bar__step') and contains(@class, 'svelte')]");
}
