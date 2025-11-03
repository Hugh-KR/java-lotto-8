package lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.constants.GameConstants;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;
import lotto.validation.InputValidator;
import lotto.view.LottoView;

public class LottoController {

    public void run() {
        final int purchaseAmount = getPurchaseAmount();
        final List<Lotto> lottos = purchaseLottos(purchaseAmount);
        LottoView.printPurchasedLottos(lottos);

        final WinningLotto winningLotto = getWinningLotto();
        final LottoResult result = new LottoResult(lottos, winningLotto);

        LottoView.printWinningStatistics(result);
        final double returnRate = result.calculateReturnRate(purchaseAmount);
        LottoView.printReturnRate(returnRate);
    }

    private int getPurchaseAmount() {
        LottoView.printPurchaseAmountInputMessage();
        while (true) {
            try {
                final String input = Console.readLine();
                return InputValidator.validatePurchaseAmount(input);
            } catch (final IllegalArgumentException e) {
                LottoView.printErrorMessage(e.getMessage());
            }
        }
    }

    private List<Lotto> purchaseLottos(final int purchaseAmount) {
        final int lottoCount = purchaseAmount / GameConstants.LOTTO_PRICE.getValue();
        final List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            final List<Integer> numbers = generateRandomNumbers();
            final Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }

        return lottos;
    }

    private List<Integer> generateRandomNumbers() {
        final List<Integer> numbers = new ArrayList<>(
                Randoms.pickUniqueNumbersInRange(
                        GameConstants.MIN_LOTTO_NUMBER.getValue(),
                        GameConstants.MAX_LOTTO_NUMBER.getValue(),
                        GameConstants.LOTTO_NUMBER_COUNT.getValue()));
        Collections.sort(numbers);
        return numbers;
    }

    private WinningLotto getWinningLotto() {
        final List<Integer> winningNumbers = getWinningNumbers();
        final int bonusNumber = getBonusNumber(winningNumbers);
        final Lotto winningLotto = new Lotto(winningNumbers);
        return new WinningLotto(winningLotto, bonusNumber);
    }

    private List<Integer> getWinningNumbers() {
        LottoView.printWinningNumbersInputMessage();
        while (true) {
            try {
                final String input = Console.readLine();
                final List<Integer> numbers = InputValidator.validateWinningNumbers(input);
                Collections.sort(numbers);
                return numbers;
            } catch (final IllegalArgumentException e) {
                LottoView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int getBonusNumber(final List<Integer> winningNumbers) {
        LottoView.printBonusNumberInputMessage();
        while (true) {
            try {
                final String input = Console.readLine();
                return InputValidator.validateBonusNumber(input, winningNumbers);
            } catch (final IllegalArgumentException e) {
                LottoView.printErrorMessage(e.getMessage());
            }
        }
    }
}
