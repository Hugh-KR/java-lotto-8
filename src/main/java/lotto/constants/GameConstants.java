package lotto.constants;

public enum GameConstants {
    LOTTO_PRICE(1000),
    MIN_LOTTO_NUMBER(1),
    MAX_LOTTO_NUMBER(45),
    LOTTO_NUMBER_COUNT(6),
    FIFTH_PLACE_PRIZE(5000),
    FOURTH_PLACE_PRIZE(50000),
    THIRD_PLACE_PRIZE(1500000),
    SECOND_PLACE_PRIZE(30000000),
    FIRST_PLACE_PRIZE(2000000000),
    FIFTH_PLACE_MATCH_COUNT(3),
    FOURTH_PLACE_MATCH_COUNT(4),
    THIRD_PLACE_MATCH_COUNT(5),
    SECOND_PLACE_MATCH_COUNT(5),
    FIRST_PLACE_MATCH_COUNT(6);

    private final int value;

    GameConstants(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
