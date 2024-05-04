package ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class IntegrationSocialNetworkPage {

    public final SelenideElement acceptYouTube = $x("//*[@aria-label='Accept all']");
    public final SelenideElement youTubeChannel = $x("//span[@class='yt-core-attributed-string yt-core-attributed-string--white-space-pre-wrap'][@dir='auto'][@role='text']");
    public final SelenideElement telegramChannel = $x("//span[@dir='auto']");
}
