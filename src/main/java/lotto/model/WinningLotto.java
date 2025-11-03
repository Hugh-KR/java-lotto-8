package lotto.model;

import java.util.List;

import lotto.Lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(final Lotto lotto, final int bonusNumber) {
        validateBonusNumber(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(final Lotto lotto, final int bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public LottoRank getRank(final Lotto userLotto) {
        final int matchCount = userLotto.countMatchNumbers(lotto.getNumbers());
        final boolean hasBonus = userLotto.contains(bonusNumber);
        return LottoRank.valueOf(matchCount, hasBonus);
    }

    public List<Integer> getWinningNumbers() {
        return lotto.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
