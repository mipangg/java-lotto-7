package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoMachine {

    private final Random random = new Random();
    private final Validator validator = new Validator();

    private int bonusNumber;
    private Lotto winningLotto;

    public void setWinningNumbers(String winningNumbersText) {
        List<Integer> winningNumbers = new ArrayList<>();

        String[] split = winningNumbersText.split(",");
        for (String s : split) {
            int number = Integer.parseInt(s.trim());
            validator.validateLottoNumber(number);
            if (!winningNumbers.contains(number)) {
                winningNumbers.add(number);
            }
        }

        Collections.sort(winningNumbers);
        this.winningLotto = new Lotto(winningNumbers);
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public int getLottoAmount(int price) {
        return price / 1000;
    }

    public List<Lotto> getLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    private Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 6) {
            int randomNumber = generateRandomNumber();
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        Collections.sort(numbers);
        return new Lotto(numbers);
    }

    private int generateRandomNumber() {
        return random.nextInt(45) + 1;
    }

}
