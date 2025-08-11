package lotto;

import java.util.Scanner;

public class LottoStore {

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

}
