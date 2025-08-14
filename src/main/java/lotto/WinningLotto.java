package lotto;

import java.util.List;

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
}
