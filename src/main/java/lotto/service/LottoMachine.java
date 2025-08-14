package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;

public class LottoMachine {

    // 구입 가능한 로또 양을 반환
    public int getLottoAmount(int price) {
        return price / 1000;
    }

    // 잔돈 반환
    public int getChange(int price) {
        return price % 1000;
    }

    // 원하는 만큼 로또 구입
    public List<Lotto> getLottos(int amount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottos.add(generateLotto());
        }

        return lottos;
    }

    // 손님의 로또 결과 확인
    public Customer getCustomerResult(WinningLotto winningLotto, Customer customer) {
        customer.setResult(winningLotto);
        customer.setEarningRate();
        return customer;
    }

    // 로또 생성
    private Lotto generateLotto() {
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < 6) {
            int number = random.nextInt(45) + 1;
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }

        return new Lotto(numbers);
    }

}
