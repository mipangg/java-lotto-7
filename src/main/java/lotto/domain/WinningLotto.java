package lotto.domain;

import java.util.List;
import lotto.util.Validator;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        Lotto winningLotto = new Lotto(winningNumbers);
        validate(winningLotto, bonusNumber);
        this.lotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        Validator validator = new Validator();
        validator.numberInBounds(bonusNumber);
        validator.duplicateBonusNumber(winningLotto, bonusNumber);
    }

    public Lotto getWinningLotto() {
        return lotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public int getMatchCount(Lotto customerLotto) {
        int matchCount = 0;
        List<Integer> winningNumbers = lotto.getNumbers();

        for (Integer winningNumber : winningNumbers) {
            if (customerLotto.contains(winningNumber)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
