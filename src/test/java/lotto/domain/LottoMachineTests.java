package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.NONE;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTests {

    private final LottoMachine lottoMachine = new LottoMachine();

    @Test
    @DisplayName("구입 금액 중 1000으로 나누어 떨어지는 만큼 로또를 구입할 수 있고 나머지는 잔돈이 된다")
    void purchaseLottoAndReturnChangeTest() {

        int price = 8500;
        int expectedLottoAmount = 8;
        int expectedChange = 500;

        int actualLottoAmount = lottoMachine.getLottoAmount(price);
        int actualChange = lottoMachine.getChange(price);

        assertThat(actualLottoAmount).isEqualTo(expectedLottoAmount);
        assertThat(actualChange).isEqualTo(expectedChange);

    }

    @Test
    @DisplayName("원하는 양만큼 로또를 구매할 수 있다")
    void customerCanGetLottoAsMuchAsTheyWant() {

        int amount = 8;
        int lottoSize = 6;
        List<Lotto> lottos = lottoMachine.getLottos(amount);

        assertThat(lottos).hasSize(amount);

        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).hasSize(lottoSize);
        }
    }

    @Test
    @DisplayName("로또 결과 확인 후 손님의 정보에 당첨 결과와 수익률이 업데이트 되어 있다")
    void getCustomerResultTest() {

        Customer customer = new Customer(
                List.of(
                        new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                        new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                        new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                        new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                        new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                        new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                        new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                        new Lotto(List.of(1, 3, 5, 14, 22, 45))
                )
        );
        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        double expectedEarningRate = BigDecimal.valueOf(5000)
                .divide(BigDecimal.valueOf(8000), 2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .doubleValue();

        Customer updatedCustomer = lottoMachine.getCustomerResult(winningLotto, customer);

        Map<Rank, Integer> customerResult = updatedCustomer.getResult();
        assertThat(customerResult.get(FIRST)).isEqualTo(0);
        assertThat(customerResult.get(SECOND)).isEqualTo(0);
        assertThat(customerResult.get(THIRD)).isEqualTo(0);
        assertThat(customerResult.get(FOURTH)).isEqualTo(0);
        assertThat(customerResult.get(FIFTH)).isEqualTo(1);
        assertThat(customerResult.get(NONE)).isEqualTo(7);

        assertThat(updatedCustomer.getEarningRate()).isEqualTo(expectedEarningRate);

    }

}