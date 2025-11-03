package lotto.view;

import java.util.List;

import lotto.Lotto;
import lotto.constants.MessageConstants;
import lotto.constants.OutputConstants;
import lotto.model.LottoRank;
import lotto.model.LottoResult;

public class LottoView {

    private LottoView() {
        // 유틸리티 클래스이므로 인스턴스 생성 방지
    }

    public static void printPurchaseAmountInputMessage() {
        System.out.println(MessageConstants.PURCHASE_AMOUNT_INPUT_MESSAGE.getMessage());
    }

    public static void printWinningNumbersInputMessage() {
        System.out.println(MessageConstants.WINNING_NUMBERS_INPUT_MESSAGE.getMessage());
    }

    public static void printBonusNumberInputMessage() {
        System.out.println(MessageConstants.BONUS_NUMBER_INPUT_MESSAGE.getMessage());
    }

    public static void printPurchasedLottos(final List<Lotto> lottos) {
        final int count = lottos.size();
        System.out.println(count + MessageConstants.PURCHASE_COUNT_MESSAGE.getMessage());
        for (final Lotto lotto : lottos) {
            printLottoNumbers(lotto);
        }
        System.out.println();
    }

    private static void printLottoNumbers(final Lotto lotto) {
        final List<Integer> numbers = lotto.getNumbers();
        final StringBuilder builder = new StringBuilder();
        builder.append(OutputConstants.LOTTO_START_BRACKET.getValue());
        for (int i = 0; i < numbers.size(); i++) {
            builder.append(numbers.get(i));
            if (i < numbers.size() - 1) {
                builder.append(OutputConstants.NUMBER_SEPARATOR.getValue());
            }
        }
        builder.append(OutputConstants.LOTTO_END_BRACKET.getValue());
        System.out.println(builder.toString());
    }

    public static void printWinningStatistics(final LottoResult result) {
        System.out.println(MessageConstants.WINNING_STATISTICS_MESSAGE.getMessage());
        System.out.println(MessageConstants.WINNING_STATISTICS_SEPARATOR.getMessage());
        printRankResult(LottoRank.FIFTH, result);
        printRankResult(LottoRank.FOURTH, result);
        printRankResult(LottoRank.THIRD, result);
        printRankResultWithBonus(LottoRank.SECOND, result);
        printRankResult(LottoRank.FIRST, result);
    }

    private static void printRankResult(final LottoRank rank, final LottoResult result) {
        final int matchCount = rank.getMatchCount();
        final long prize = rank.getPrize();
        final int count = result.getRankCount(rank);
        final String message = buildRankMessage(matchCount, prize, count);
        System.out.println(message);
    }

    private static void printRankResultWithBonus(final LottoRank rank, final LottoResult result) {
        final int matchCount = rank.getMatchCount();
        final long prize = rank.getPrize();
        final int count = result.getRankCount(rank);
        final String message = buildRankMessageWithBonus(matchCount, prize, count);
        System.out.println(message);
    }

    private static String buildRankMessage(final int matchCount, final long prize, final int count) {
        return matchCount + OutputConstants.MATCH_COUNT_SUFFIX.getValue()
                + OutputConstants.PRIZE_PREFIX.getValue()
                + formatPrize(prize)
                + OutputConstants.PRIZE_SUFFIX.getValue()
                + OutputConstants.WINNING_DETAIL_SEPARATOR.getValue()
                + count + "개";
    }

    private static String buildRankMessageWithBonus(final int matchCount, final long prize,
            final int count) {
        return matchCount + OutputConstants.MATCH_COUNT_SUFFIX.getValue()
                + ", "
                + OutputConstants.BONUS_BALL_MATCH.getValue()
                + OutputConstants.PRIZE_PREFIX.getValue()
                + formatPrize(prize)
                + OutputConstants.PRIZE_SUFFIX.getValue()
                + OutputConstants.WINNING_DETAIL_SEPARATOR.getValue()
                + count + "개";
    }

    private static String formatPrize(final long prize) {
        return String.format("%,d", prize);
    }

    public static void printReturnRate(final double returnRate) {
        System.out.println(MessageConstants.TOTAL_RETURN_RATE_MESSAGE.getMessage()
                + returnRate
                + MessageConstants.PERCENTAGE_SUFFIX.getMessage());
    }

    public static void printErrorMessage(final String message) {
        System.out.println(message);
    }
}
