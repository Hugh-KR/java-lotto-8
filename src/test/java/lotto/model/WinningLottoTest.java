package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Lotto;

class WinningLottoTest {

    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        final Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        assertThatThrownBy(() -> new WinningLotto(lotto, 6))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 로또의_당첨_등급을_계산한다() {
        final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final WinningLotto winningLottoWithBonus = new WinningLotto(winningLotto, 7);
        final Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        final LottoRank rank = winningLottoWithBonus.getRank(userLotto);
        assertThat(rank).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 보너스_번호가_있으면_2등이_된다() {
        final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final WinningLotto winningLottoWithBonus = new WinningLotto(winningLotto, 7);
        final Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        final LottoRank rank = winningLottoWithBonus.getRank(userLotto);
        assertThat(rank).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("보너스 번호 없이 5개 일치하면 3등이다")
    @Test
    void 보너스_번호_없이_5개_일치하면_3등() {
        final Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        final WinningLotto winningLottoWithBonus = new WinningLotto(winningLotto, 7);
        final Lotto userLotto = new Lotto(List.of(1, 2, 3, 4, 5, 45));

        final LottoRank rank = winningLottoWithBonus.getRank(userLotto);
        assertThat(rank).isEqualTo(LottoRank.THIRD);
    }
}
