package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import lotto.Lotto;

class LottoResultTest {

    @Test
    void 당첨_통계를_계산한다() {
        final List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
        lottos.add(new Lotto(List.of(1, 2, 3, 40, 41, 42)));

        final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final WinningLotto winningLottoWithBonus = new WinningLotto(winningLotto, 7);

        final LottoResult result = new LottoResult(lottos, winningLottoWithBonus);

        assertThat(result.getRankCount(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.getRankCount(LottoRank.SECOND)).isEqualTo(1);
        assertThat(result.getRankCount(LottoRank.FIFTH)).isEqualTo(1);
    }

    @Test
    void 총_당첨금을_계산한다() {
        final List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        lottos.add(new Lotto(List.of(1, 2, 3, 40, 41, 42)));

        final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final WinningLotto winningLottoWithBonus = new WinningLotto(winningLotto, 7);

        final LottoResult result = new LottoResult(lottos, winningLottoWithBonus);

        assertThat(result.getTotalPrize()).isEqualTo(2000005000L);
    }

    @Test
    void 수익률을_계산한다() {
        final List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final WinningLotto winningLottoWithBonus = new WinningLotto(winningLotto, 7);
        final LottoResult result = new LottoResult(lottos, winningLottoWithBonus);

        final double returnRate = result.calculateReturnRate(1000);
        assertThat(returnRate).isEqualTo(200000000.0);
    }
}
