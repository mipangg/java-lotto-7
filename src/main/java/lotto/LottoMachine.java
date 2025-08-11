package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final Validator validator = new Validator();

    public Lotto getWinningNumbers(String winningNumbersText) {
        List<Integer> winningNumbers = new ArrayList<>();

        String[] split = winningNumbersText.split(",");
        for (String s : split) {
            int number = Integer.parseInt(s.trim());
            validator.validateLottoNumber(number);
            winningNumbers.add(number);
        }

        return new Lotto(winningNumbers);
    }

    public int getLottoAmount(int price) {
        return price / 1000;
    }

}
