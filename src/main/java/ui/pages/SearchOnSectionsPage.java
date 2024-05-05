package ui.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class SearchOnSectionsPage {

    public final SelenideElement searchInput = $x("//jr-search-panel[@class='header']//input[contains(@class, 'search-panel__input')]");
    public final SelenideElement enteringIntoSearch = $x("//jr-search-panel[@class='header expanded']//input[@placeholder='Поиск']");
    public final SelenideElement resultAll = $x("//li[contains(@class,'tasks-list__item')]");
    public final SelenideElement resultList = $x("//em[contains(text(),'тестирова')]");

    public final SelenideElement resultList2 = $x("//li[@class='tabs__item tabs__item--active']");
}
