package lotto.constants;

public enum SeparatorConstants {
    WINNING_NUMBERS_SEPARATOR(",");

    private final String separator;

    SeparatorConstants(final String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }
}
