package lotto.model;

import lotto.constants.GameConstants;

public enum LottoRank {
    FIRST(GameConstants.FIRST_PLACE_MATCH_COUNT.getValue(),
            GameConstants.FIRST_PLACE_PRIZE.getValue(),
            false),
    SECOND(GameConstants.SECOND_PLACE_MATCH_COUNT.getValue(),
            GameConstants.SECOND_PLACE_PRIZE.getValue(),
            true),
    THIRD(GameConstants.THIRD_PLACE_MATCH_COUNT.getValue(),
            GameConstants.THIRD_PLACE_PRIZE.getValue(),
            false),
    FOURTH(GameConstants.FOURTH_PLACE_MATCH_COUNT.getValue(),
            GameConstants.FOURTH_PLACE_PRIZE.getValue(),
            false),
    FIFTH(GameConstants.FIFTH_PLACE_MATCH_COUNT.getValue(),
            GameConstants.FIFTH_PLACE_PRIZE.getValue(),
            false),
    NONE(0, 0, false);

    private final int matchCount;
    private final long prize;
    private final boolean requiresBonus;

    LottoRank(final int matchCount, final long prize, final boolean requiresBonus) {
        this.matchCount = matchCount;
        this.prize = prize;
        this.requiresBonus = requiresBonus;
    }

    public static LottoRank valueOf(final int matchCount, final boolean hasBonus) {
        for (final LottoRank rank : values()) {
            if (rank.matchCount == matchCount && rank.requiresBonus == hasBonus) {
                return rank;
            }
        }
        return NONE;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    public boolean requiresBonus() {
        return requiresBonus;
    }
}
