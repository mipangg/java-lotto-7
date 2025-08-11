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
        int price = clerk.inputLottoPurchaseAmount();
        int lottoAmount = lottoMachine.getLottoAmount(price);
        List<Lotto> customerLottos = lottoMachine.getLottos(lottoAmount);
        clerk.printChange(price);

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
