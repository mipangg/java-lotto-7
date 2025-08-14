package lotto.domain;

import java.util.List;
import lotto.util.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Validator validator = new Validator();
        validator.lottoSize(numbers);
        validator.duplicateNumbers(numbers);
        validator.numbersInBounds(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }
}