package lotto.model;

import java.util.EnumMap;
import java.util.List;

import lotto.Lotto;

public class LottoResult {
    private final EnumMap<LottoRank, Integer> rankCount;
    private final long totalPrize;

    public LottoResult(final List<Lotto> lottos, final WinningLotto winningLotto) {
        this.rankCount = new EnumMap<>(LottoRank.class);
        initializeRankCount();
        calculateResults(lottos, winningLotto);
        this.totalPrize = calculateTotalPrize();
    }

    private void initializeRankCount() {
        for (final LottoRank rank : LottoRank.values()) {
            rankCount.put(rank, 0);
        }
    }

    private void calculateResults(final List<Lotto> lottos, final WinningLotto winningLotto) {
        for (final Lotto lotto : lottos) {
            final LottoRank rank = winningLotto.getRank(lotto);
            rankCount.put(rank, rankCount.get(rank) + 1);
        }
    }

    private long calculateTotalPrize() {
        long total = 0;
        for (final LottoRank rank : LottoRank.values()) {
            total += (long) rankCount.get(rank) * rank.getPrize();
        }
        return total;
    }

    public int getRankCount(final LottoRank rank) {
        return rankCount.get(rank);
    }

    public long getTotalPrize() {
        return totalPrize;
    }

    public double calculateReturnRate(final long purchaseAmount) {
        if (purchaseAmount == 0) {
            return 0.0;
        }
        return Math.round((double) totalPrize / purchaseAmount * 100.0 * 10.0) / 10.0;
    }
}
