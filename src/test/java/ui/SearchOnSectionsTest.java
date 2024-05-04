package ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("JRUI")
@Owner("Катасонова Мария")
@Feature("Автотесты для UI")
@Story("Поиск в разделах в приложения")
@DisplayName("Поиск в разделах в приложения")
public class SearchOnSectionsTest extends TestBase {

    @CsvSource(value = {
            "Лекции", "Задачи", "Статьи",
            "Группы", "Вопросы", "Комментарии",
    })
    @ParameterizedTest
    @DisplayName("Поиск 'Тестирования' на всех разделах")
    void searchOnAllSections(String param) {
        startStep.openJavaRush();
        sidebarStep.pressSidebarWell();
        searchOnSectionsStep.pressSearchInput();
        searchOnSectionsStep.enterSearchSetValue();
        sidebarStep.pressSection(param);
        searchOnSectionsStep.checkResultPressSection();
    }

    @Test
    @DisplayName("Поиск 'Тестирования' в общей вкладке")
    void searchInTheGeneralSection() {
        startStep.openJavaRush();
        sidebarStep.pressSidebarWell();
        searchOnSectionsStep.pressSearchInput();
        searchOnSectionsStep.enterSearchSetValue();
        searchOnSectionsStep.checkResultAll();
    }
}
