package ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class FunctionOfTheStartTrainingPage {

    public final SelenideElement checkThisIsWhereTheyBecomeJavaProgrammers = $x("//div[contains(@Class,'quiz-home-section__head') and contains(@Class,'svelte')]");
}
