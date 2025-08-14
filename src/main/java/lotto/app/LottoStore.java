package lotto.app;

import java.util.List;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.service.Clerk;
import lotto.service.LottoMachine;
import lotto.util.Formatter;

public class LottoStore {
    private final Formatter formatter = new Formatter();
    private final Clerk clerk = new Clerk();
    private final LottoMachine lottoMachine = new LottoMachine();

    public void enter() {
        int price = getPriceFromCustomer();
        int amount = getLottoAmount(price);
        Customer customer = getCustomerLottos(amount);
        showCustomerLottos(customer, amount, price);
        WinningLotto winningLotto = getWinningLotto(getWinningNumbers(), getBonusNumber());
        customer = getCustomerLottoResult(winningLotto, customer);
        showCustomerLottoResult(customer);
    }

    // 로또 구입 금액 얻기
    private int getPriceFromCustomer() {
        String priceStr = clerk.inputLottoPurchaseAmount();
        try {
            return formatter.toPrice(priceStr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPriceFromCustomer();
        }
    }

    // 손님이 구매할 로또 개수 얻고 잔돈 반환하기
    private int getLottoAmount(int price) {
        return lottoMachine.getLottoAmount(price);
    }

    // 손님의 로또 생성 후 저장
    private Customer getCustomerLottos(int amount) {
        List<Lotto> customerLottos = lottoMachine.getLottos(amount);
        return new Customer(customerLottos);
    }

    // 손님의 로또 정보 출력
    private void showCustomerLottos(Customer customer, int amount, int price) {
        clerk.outputCustomerLottos(customer, amount);
        if (price % 1000 != 0) {
            clerk.outputChange(lottoMachine.getChange(price));
        }
    }

    // 당첨 번호 입력
    private Lotto getWinningNumbers() {
        String winningNumbersStr = clerk.inputWinningLotto();
        try {
            return new Lotto(formatter.toWinningNumbers(winningNumbersStr));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumbers();
        }
    }

    // 보너스 번호 입력
    private int getBonusNumber() {
        String bonusNumberStr = clerk.inputBonusNumber();
        try {
            return formatter.toBonusNumber(bonusNumberStr);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }

    // 당첨 번호 저장
    private WinningLotto getWinningLotto(Lotto winningLotto, int bonusNumber) {
        try {
            return new WinningLotto(winningLotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto(winningLotto, getBonusNumber());
        }
    }

    // 로또 결과 계산
    private Customer getCustomerLottoResult(WinningLotto winningLotto, Customer customer) {
        return lottoMachine.getCustomerResult(winningLotto, customer);
    }

    // 로또 결과 출력
    private void showCustomerLottoResult(Customer customer) {
        clerk.outputWinningResult(customer);
    }

}
