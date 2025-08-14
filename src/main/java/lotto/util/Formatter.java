package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Formatter {

    private final Validator validator = new Validator();

    public int toPrice(String priceStr) {
        int price = validator.isNumberFormat(priceStr);

        validator.lottoAmount(price);

        return price;
    }

    public List<Integer> toWinningNumbers(String winningNumbersStr) {
        List<Integer> winningNumbers = new ArrayList<>();

        String[] split = winningNumbersStr.split(",");
        for (String s : split) {
            winningNumbers.add(validator.isNumberFormat(s.trim()));
        }

        Collections.sort(winningNumbers);
        return winningNumbers;
    }

    public int toBonusNumber(String bonusNumberStr) {
        return validator.isNumberFormat(bonusNumberStr);
    }
}
