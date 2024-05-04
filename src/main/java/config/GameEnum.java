package config;

public enum GameEnum {
    EXPECTED_DESCRIPTION_SNAKE("Змейка"),
    EXPECTED_DESCRIPTION_MINESWEEPER("Сапер"),
    EXPECTED_DESCRIPTION_MOON_LANDER("Moon Lander");

    public final String value;
    GameEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
