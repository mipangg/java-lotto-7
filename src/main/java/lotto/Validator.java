package lotto;

import java.util.List;

public class Validator {

    public void lottoSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorCode.WRONG_LOTTO_SIZE.getMessage());
        }
    }

    public void duplicateNumbers(List<Integer> numbers) {
        List<Integer> distinctNumbers = numbers.stream().distinct().toList();
        if (distinctNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_NUMBER.getMessage());
        }
    }

    public void numbersInBounds(List<Integer> numbers) {
        for (Integer number : numbers) {
            numberInBounds(number);
        }
    }

    public void numberInBounds(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorCode.OUT_OF_BOUNDS.getMessage());
        }
    }

    public void duplicateBonusNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_NUMBER.getMessage());
        }
    }
}
