package lotto.constants;

public enum OutputConstants {
    LOTTO_START_BRACKET("["),
    LOTTO_END_BRACKET("]"),
    NUMBER_SEPARATOR(", "),
    WINNING_DETAIL_SEPARATOR(" - "),
    MATCH_COUNT_SUFFIX("개 일치"),
    PRIZE_PREFIX(" ("),
    PRIZE_SUFFIX("원)"),
    BONUS_BALL_MATCH("보너스 볼 일치");

    private final String value;

    OutputConstants(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
