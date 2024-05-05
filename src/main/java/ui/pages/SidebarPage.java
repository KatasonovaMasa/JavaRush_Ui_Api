package ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SidebarPage {

    public final SelenideElement sidebar = $x("//span[@class='toggle-menu-button__icon']");
    public final SelenideElement sidebarWell = $x("//div[contains(text(),'Задачи')]");
    public final SelenideElement sidebarSettings = $x("//div[contains(@class,'sidebar-nav-label') and contains(text(),'Настройки')]");
    public final SelenideElement sidebarBookmarks = $x("//div[contains(@class,'sidebar-nav-label') and contains(text(),'Закладки')]");

    public SelenideElement sidebarMenuType(String typeElement) {
        return $(byTagAndText("div", (typeElement)));
    }
    public SelenideElement sectionApplication(String param) {
        return $x(String.format("//a[contains(@class,'tabs__button') and contains(text(),'%s')]", param));
    }
}
