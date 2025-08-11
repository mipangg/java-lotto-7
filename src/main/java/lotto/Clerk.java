package lotto;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Clerk {

    private Scanner sc = new Scanner(System.in);
    private final Validator validator = new Validator();

    public int inputLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public String inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        sc.nextLine();
        return sc.nextLine();
    }

    public int inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        try {
            return validator.validateLottoNumber(sc.nextInt());
        } catch (IllegalArgumentException e) {
            return inputBonusNumber();
        }
    }

    public void printChange(int price) {
        int change = price % 1000;

        if (change != 0) {
            System.out.println("\n거스름돈: " + price % 1000);
        }
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println("\n" + lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printResult(Customer customer) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Map<Rank, Integer> winnings = customer.getWinnings();
        System.out.println(Rank.FIFTH.toString(winnings.get(Rank.FIFTH)));
        System.out.println(Rank.FOURTH.toString(winnings.get(Rank.FOURTH)));
        System.out.println(Rank.THIRD.toString(winnings.get(Rank.THIRD)));
        System.out.println(Rank.SECOND.toString(winnings.get(Rank.SECOND)));
        System.out.println(Rank.FIRST.toString(winnings.get(Rank.FIRST)));

        System.out.println("총 수익률은 " + customer.getEarningRate() + "%입니다.");
    }

}
