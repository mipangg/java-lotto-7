package lotto;

import java.util.List;
import java.util.Scanner;

public class Clerk {

    private Scanner sc = new Scanner(System.in);

    public int inputLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public String inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }

    public int inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return sc.nextInt();
    }

    public void printChange(int price) {
        int change = price % 1000;

        if (change != 0) {
            System.out.println("거스름돈: " + price % 1000);
        }
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printResult(Customer customer) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 ( " + Prize.FIFTH.getPrize() + "원) - "+ 0 + "개");
        System.out.println("4개 일치 ( " + Prize.FORTH.getPrize() + "원) - "+ 0 + "개");
        System.out.println("5개 일치 ( " + Prize.THIRD.getPrize() + "원) - "+ 0 + "개");
        System.out.println("5개 일치, 보너스 볼 일치 ( " + Prize.SECOND.getPrize() + "원) - "+ 0 + "개");
        System.out.println("6개 일치 ( " + Prize.FIRST.getPrize() + "원) - "+ 0 + "개");
        System.out.println("총 수익률은 " + 0 + "%입니다.");
    }

}
