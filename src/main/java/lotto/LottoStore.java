package lotto;

import java.util.List;

public class LottoStore {

    private final Clerk clerk = new Clerk();
    private final LottoMachine lottoMachine = new LottoMachine();

    public void enter() {
        Customer customer = purchaseLotto();
        setWinningLotto();
        checkLotto(customer);
    }

    private Customer purchaseLotto() {
        int lottoAmount = clerk.inputLottoPurchaseAmount();
        List<Lotto> customerLottos = lottoMachine.getLottos(lottoAmount);
        clerk.printChange(lottoAmount);

        Customer customer = new Customer(customerLottos);
        clerk.printLottos(customerLottos);

        return customer;
    }

    private void setWinningLotto() {
        String winningNumbersText = clerk.inputWinningNumbers();
        lottoMachine.setWinningNumbers(winningNumbersText);

        int bonusNumber = clerk.inputBonusNumber();
        lottoMachine.setBonusNumber(bonusNumber);
    }

    private void checkLotto(Customer customer) {
        customer = lottoMachine.checkLottoResult(customer);
        clerk.printResult(customer);
    }
}
