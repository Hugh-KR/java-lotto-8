package lotto.validation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputValidatorTest {

    @Test
    void 구입_금액이_1000원_단위가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 구입_금액이_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 구입_금액이_음수이면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validatePurchaseAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 유효한_구입_금액을_반환한다() {
        final int amount = InputValidator.validatePurchaseAmount("5000");
        assertThat(amount).isEqualTo(5000);
    }

    @Test
    void 당첨_번호_개수가_6개가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 당첨_번호에_중복이_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("1,2,3,4,5,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 당첨_번호가_범위를_벗어나면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateWinningNumbers("1,2,3,4,5,50"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @DisplayName("유효한 당첨 번호를 반환한다")
    @Test
    void 유효한_당첨_번호를_반환한다() {
        final List<Integer> numbers = InputValidator.validateWinningNumbers("1,2,3,4,5,6");
        assertThat(numbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 보너스_번호가_범위를_벗어나면_예외가_발생한다() {
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> InputValidator.validateBonusNumber("50", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThatThrownBy(() -> InputValidator.validateBonusNumber("6", winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 유효한_보너스_번호를_반환한다() {
        final List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        final int bonusNumber = InputValidator.validateBonusNumber("7", winningNumbers);
        assertThat(bonusNumber).isEqualTo(7);
    }
}
