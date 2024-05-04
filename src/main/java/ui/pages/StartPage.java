package ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class StartPage {

    public final SelenideElement startLearningOne = $x("//a[contains(@class, 'btn btn--hero btn--sm btn--label-size-l svelte')]//span[contains(@class, 'btn__label svelte') and contains(text(),'Начать обучение')]");
    public final SelenideElement startLearningTwo = $x("//span[contains(@class,'btn__label svelte') and contains(text(),'Начать обучение БЕСПЛАТНО')]");
    public final SelenideElement closeCookie = $x("//button[contains(@class, 'button') and contains(@class,'button--sm-wide') and contains(@class, 'button--apply')]");
    public final SelenideElement downloadButton = $x("//img[@alt='Google Play']");
    public final SelenideElement openYouTube = $x("//*[contains(@class, 'footer-soc__link--youtube')]");
    public final SelenideElement openTelegram = $x("//*[contains(@class, 'footer-soc__link--telegram')]");
}
