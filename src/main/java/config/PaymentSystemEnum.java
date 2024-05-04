package config;

public enum PaymentSystemEnum {

    EXPECTED_VISA("visa"),
    EXPECTED_MAESTRO("maestro"),
    EXPECTED_MIR("мир");

    public final String value;
    PaymentSystemEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
