package ui.steps;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import ui.pages.SidebarPage;
import ui.pages.StartPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.sleep;

public class SidebarStep {

    SidebarPage sidebarPage = new SidebarPage();

    StartPage startPage = new StartPage();//добавила

    @Step("Нажать на раздел приложения ")
    public void pressSection(String param) {
        sleep(1000);
        sidebarPage.sectionApplication(param).click();
    }

    @Step("Нажать на сайдбар 'Задачи'")
    public void pressSidebarWell() {
        if (sidebarPage.sidebar.has(visible)) {
            sidebarPage.sidebar.click();
            sidebarPage.sidebarWell.click();
        } else {
            sidebarPage.sidebarWell.click();
        }
    }

    @Step("Пролистать вниз и открыть 'Настройки' ")
    public void scrollDownAndOpenSettings() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        sidebarPage.sidebarBookmarks.scrollTo();
        sidebarPage.sidebarSettings.click();
    }

    @Step("Нажать на пункт меню")
    public void pressSidebarMenu(String typeElement) {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        sidebarPage.sidebarMenuType(typeElement).click();
    }
}
