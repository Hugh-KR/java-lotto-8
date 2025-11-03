package lotto;

import java.util.Collections;
import java.util.List;

import lotto.constants.ErrorConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(final List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(
                    ErrorConstants.INVALID_LOTTO_NUMBERS_COUNT_ERROR.getErrorMessage());
        }
        if (numbers.stream().distinct().count() != numbers.size()) {
            throw new IllegalArgumentException(
                    ErrorConstants.DUPLICATE_LOTTO_NUMBERS_ERROR.getErrorMessage());
        }
    }

    public int countMatchNumbers(final List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public int countMatchNumbers(final Lotto otherLotto) {
        return countMatchNumbers(otherLotto.getNumbers());
    }

    public boolean contains(final int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
