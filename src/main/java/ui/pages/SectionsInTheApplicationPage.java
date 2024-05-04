package ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SectionsInTheApplicationPage {

    public SelenideElement checkMenuTabType(String typeElement) {
        return $x(String.format("//h1[contains(text(),'%s')]", typeElement));
    }
}