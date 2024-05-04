package config;

public enum LanguageEnum {

    EXPECTED_RUSSIAN("RUSSIAN"),
    EXPECTED_UKRAINIAN("UKRAINIAN"),
    EXPECTED_ENGLISH("ENGLISH");

    public final String value;
    LanguageEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
