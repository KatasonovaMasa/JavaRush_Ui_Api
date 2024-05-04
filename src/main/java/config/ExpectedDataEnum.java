package config;

public enum ExpectedDataEnum {

    EXPECTED_CONTENT_GAMES("Длинное змееобразное существо ползает по ограниченному полю, подчиняясь приказам игрока (право, лево, вниз, вверх)."),
    EXPECTED_SERVER_NAME("javarush.com"),
    EXPECTED_APPLICATION_ID("JAVARUSH"),
    EXPECTED_PROJECT_ID("jaxarush-app"),
    EXPECTED_TYPE_NEWS("TASK_IN_PROGRESS"),
    EXPECTED_DESCRIPTION_NEWS("пробует решить"),
    EXPECTED_ID_NEWS("3"),
    EXPECTED_KEY_NEWS("anonymous#"),
    EXPECTED_USER_ID_NEWS("3"),
    EXPECTED_PICTURE_URL_USERS("anonymous.svg"),
    EXPECTED_KEY_USERS("anonymous#"),
    EXPECTED_OWNER_COMMENT("anonymous#2167660"),
    EXPECTED_DISCUSSIONS_MESSAGE("Очень полезно и интересно, спасибо! Для Python у вас нету такого? Интересные задачи, затягивает)"),
    EXPECTED_DISCUSSIONS_TYPE("ARTICLE"),
    EXPECTED_CODE("UNKNOWN_ERROR"),
    EXPECTED_RECOMMENDATION("Copy this screen and send it to support@javarush.com"),
    EXPECTED_TITLE_INFO_INTERNSHIP("Стажировка JavaRush — ваша первая работа"),
    EXPECTED_DISPLAY_NAME("Зепп Бранниган"),
    EXPECTED_TITLE_INTERVIEW("Собеседование. Путь самурая."),
    EXPECTED_POSITION_QA("QA Automation Engineer"),
    EXPECTED_POSITION_BACK("Backend Developer"),
    EXPECTED_USER_DISPLAY_NAME("Dandie KYT"),
    EXPECTED_USER_NAME("jvatechs"),
    EXPECTED_USER_CITY("Йошкар-Ола");

    public final String value;
    ExpectedDataEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
