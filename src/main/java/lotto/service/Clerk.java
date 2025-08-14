package lotto.service;

import java.util.Scanner;
import lotto.domain.Customer;

public class Clerk {
    private Scanner sc = new Scanner(System.in);

    public String inputLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextLine().trim();
    }

    public String inputWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return sc.nextLine().trim();
    }

    public String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return sc.nextLine().trim();
    }

    public void outputChange(int change) {
        System.out.println("거스름돈: " + change);
    }

    public void outputWinningResult(Customer customer) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(customer.getTotalResult());
        System.out.println(customer.getTotalEarningRate());
    }

}
