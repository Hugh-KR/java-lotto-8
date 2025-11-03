package lotto.validation;

import java.util.ArrayList;
import java.util.List;

import lotto.constants.ErrorConstants;
import lotto.constants.GameConstants;
import lotto.constants.SeparatorConstants;

public class InputValidator {

    private InputValidator() {
        // 유틸리티 클래스이므로 인스턴스 생성 방지
    }

    public static int validatePurchaseAmount(final String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorConstants.EMPTY_PURCHASE_AMOUNT_ERROR.getErrorMessage());
        }

        try {
            final int purchaseAmount = Integer.parseInt(input.trim());
            validatePurchaseAmountValue(purchaseAmount);
            return purchaseAmount;
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(
                    ErrorConstants.NON_NUMERIC_PURCHASE_AMOUNT_ERROR.getErrorMessage());
        }
    }

    private static void validatePurchaseAmountValue(final int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException(
                    ErrorConstants.INVALID_PURCHASE_AMOUNT_ERROR.getErrorMessage());
        }
        if (purchaseAmount % GameConstants.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(
                    ErrorConstants.INVALID_PURCHASE_AMOUNT_ERROR.getErrorMessage());
        }
    }

    public static List<Integer> validateWinningNumbers(final String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorConstants.EMPTY_WINNING_NUMBERS_ERROR.getErrorMessage());
        }

        final String[] numberStrings = input.split(
                SeparatorConstants.WINNING_NUMBERS_SEPARATOR.getSeparator());
        if (numberStrings.length != GameConstants.LOTTO_NUMBER_COUNT.getValue()) {
            throw new IllegalArgumentException(
                    ErrorConstants.INVALID_WINNING_NUMBERS_COUNT_ERROR.getErrorMessage());
        }

        final List<Integer> numbers = new ArrayList<>();
        for (final String numberString : numberStrings) {
            final int number = validateAndParseNumber(numberString.trim());
            validateNumberRange(number);
            if (numbers.contains(number)) {
                throw new IllegalArgumentException(
                        ErrorConstants.DUPLICATE_WINNING_NUMBERS_ERROR.getErrorMessage());
            }
            numbers.add(number);
        }

        return numbers;
    }

    public static int validateBonusNumber(final String input, final List<Integer> winningNumbers) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    ErrorConstants.EMPTY_BONUS_NUMBER_ERROR.getErrorMessage());
        }

        try {
            final int bonusNumber = Integer.parseInt(input.trim());
            validateNumberRange(bonusNumber);
            if (winningNumbers.contains(bonusNumber)) {
                throw new IllegalArgumentException(
                        ErrorConstants.DUPLICATE_BONUS_NUMBER_ERROR.getErrorMessage());
            }
            return bonusNumber;
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(
                    ErrorConstants.NON_NUMERIC_BONUS_NUMBER_ERROR.getErrorMessage());
        }
    }

    private static int validateAndParseNumber(final String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException(
                    ErrorConstants.OUT_OF_RANGE_NUMBER_ERROR.getErrorMessage());
        }
    }

    private static void validateNumberRange(final int number) {
        if (number < GameConstants.MIN_LOTTO_NUMBER.getValue()
                || number > GameConstants.MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(
                    ErrorConstants.OUT_OF_RANGE_NUMBER_ERROR.getErrorMessage());
        }
    }
}
