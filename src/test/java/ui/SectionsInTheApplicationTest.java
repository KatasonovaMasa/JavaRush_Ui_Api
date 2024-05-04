package ui;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Param;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("JRUI")
@Owner("Катасонова Мария")
@Feature("Автотесты для UI")
@Story("Разделы в приложении")
@DisplayName("Проверка разделов в приложении")
public class SectionsInTheApplicationTest extends TestBase {

    @CsvSource(value = {
            "Курс, Курс", "Задачи, Задачи", "Опросы, Опросы", "Игры, Игры", "Помощь, Помощь по задачам", "Стажировка, Как найти работу",
            "Форум, Форум", "Статьи, Статьи", "Истории успеха, Истории успеха", "Активности, Активности", "Отзывы, Отзывы",
    })
    @ParameterizedTest
    @DisplayName("Проверка разделов в приложении")
    public void openingSectionsInTheApplication(@Param("Раздел") String elementType, String elementType2) {
        startStep.openJavaRush();
        sidebarStep.pressSidebarMenu(elementType);
        sectionsInTheApplicationStep.checkMenuPage(elementType2);
    }
}
