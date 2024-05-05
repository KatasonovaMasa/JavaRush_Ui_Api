package ui.steps;

import io.qameta.allure.Step;
import ui.pages.SearchOnSectionsPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class SearchOnSectionsStep {

    SearchOnSectionsPage searchOnSectionsPage = new SearchOnSectionsPage();

    @Step("Проверить результаты поиска на странице '$s' ")
    public void checkResultPressSection() {
        searchOnSectionsPage.resultList.shouldHave(visible.because("Нет результата поиска на странице '$s' "));
    }

    @Step("Нажать на поиск")
    public void pressSearchInput() {
        sleep(1000);
        searchOnSectionsPage.searchInput.click();
    }

    @Step("Ввести в поиск 'Тестирование' и нажать Enter")
    public void enterSearchSetValue() {
        searchOnSectionsPage.enteringIntoSearch.setValue("Тестирование").pressEnter();
    }

    @Step("Проверить результат поиска")
    public void checkResultAll() {
        searchOnSectionsPage.resultAll.shouldHave(text("Тестирование").because("Нет результатов поиска"));
    }
}
