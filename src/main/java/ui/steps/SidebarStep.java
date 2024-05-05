package ui.steps;

import io.qameta.allure.Step;
import ui.pages.SidebarPage;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;

public class SidebarStep {

    SidebarPage sidebarPage = new SidebarPage();

    @Step("Нажать на раздел приложения")
    public void pressSection(String param) {
        sidebarPage.sectionApplication(param).should(hidden.because("Не смогли нажать на раздел приложения"));
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

    @Step("Пролистать вниз")
    public void scrollDownSettings() {
        sidebarPage.sidebarBookmarks.should(hidden.because("Не смогли проскролить вниз"));
        sidebarPage.sidebarBookmarks.scrollTo();
    }

    @Step("Открыть 'Настройки'")
    public void openSettings() {
        sidebarPage.sidebarSettings.should(visible.because("Не смогли открыть 'Настройки'")).click();
    }

    @Step("Нажать на пункт меню")
    public void pressSidebarMenu(String typeElement) {
        sidebarPage.sidebarMenuType(typeElement).should(visible.because("Не смогли нажать на пункт меню")).click();
    }
}
