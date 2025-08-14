package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
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

}