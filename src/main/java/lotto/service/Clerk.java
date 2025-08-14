package lotto.service;

import java.util.Scanner;
import lotto.domain.Customer;
import lotto.domain.Lotto;

public class Clerk {
    private Scanner sc = new Scanner(System.in);

    public String inputLottoPurchaseAmount() {
        System.out.println("\n구입금액을 입력해 주세요.");
        return sc.nextLine().trim();
    }

    public String inputWinningLotto() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        return sc.nextLine().trim();
    }

    public String inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        return sc.nextLine().trim();
    }

    public void outputChange(int change) {
        System.out.println("\n거스름돈: " + change);
    }

    public void outputCustomerLottos(Customer customer, int amount) {
        System.out.println("\n" + amount + "개를 구매했습니다.");
        for (Lotto lotto : customer.getLottos()) {
            System.out.println(lotto);
        }
    }

    public void outputWinningResult(Customer customer) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        System.out.println(customer.getTotalResult());
        System.out.println(customer.getTotalEarningRate());
    }

}
