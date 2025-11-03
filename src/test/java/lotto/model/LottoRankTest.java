package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoRankTest {

    @Test
    void 일치_개수와_보너스로_등급을_결정한다() {
        assertThat(LottoRank.valueOf(6, false)).isEqualTo(LottoRank.FIRST);
        assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.valueOf(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.valueOf(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.valueOf(2, false)).isEqualTo(LottoRank.NONE);
    }

    @Test
    void 등급별_당첨금을_반환한다() {
        assertThat(LottoRank.FIRST.getPrize()).isEqualTo(2000000000L);
        assertThat(LottoRank.SECOND.getPrize()).isEqualTo(30000000L);
        assertThat(LottoRank.THIRD.getPrize()).isEqualTo(1500000L);
        assertThat(LottoRank.FOURTH.getPrize()).isEqualTo(50000L);
        assertThat(LottoRank.FIFTH.getPrize()).isEqualTo(5000L);
        assertThat(LottoRank.NONE.getPrize()).isZero();
    }
}
