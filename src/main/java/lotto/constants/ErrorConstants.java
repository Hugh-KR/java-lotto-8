package lotto.constants;

public enum ErrorConstants {
    EMPTY_PURCHASE_AMOUNT_ERROR("[ERROR] 구입 금액을 입력해주세요."),
    INVALID_PURCHASE_AMOUNT_ERROR("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    NON_NUMERIC_PURCHASE_AMOUNT_ERROR("[ERROR] 구입 금액은 숫자여야 합니다."),
    EMPTY_WINNING_NUMBERS_ERROR("[ERROR] 당첨 번호를 입력해주세요."),
    INVALID_WINNING_NUMBERS_COUNT_ERROR("[ERROR] 당첨 번호는 6개여야 합니다."),
    DUPLICATE_WINNING_NUMBERS_ERROR("[ERROR] 당첨 번호에 중복된 숫자가 있습니다."),
    OUT_OF_RANGE_NUMBER_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    EMPTY_BONUS_NUMBER_ERROR("[ERROR] 보너스 번호를 입력해주세요."),
    NON_NUMERIC_BONUS_NUMBER_ERROR("[ERROR] 보너스 번호는 숫자여야 합니다."),
    DUPLICATE_BONUS_NUMBER_ERROR("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String errorMessage;

    ErrorConstants(final String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
