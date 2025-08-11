package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTests {

    private LottoMachine lottoMachine = new LottoMachine();

    @Test
    @DisplayName("로또 구입 금액을 입력하면 구입 가능한 로또 개수를 반환하고 잔돈을 출력한다.")
    void getLottoAmountTest() {

        int amount = 8500;

        int result = lottoMachine.getLottoAmount(amount);

        assertThat(result).isEqualTo(amount / 1000);

    }

    @Test
    @DisplayName("1~45 사이의 당첨 번호 6개를 입력 받아 로또를 반환할 수 있다.")
    void getWinningNumbersTest() {

        String winningNumbersText = "1, 7, 13, 33, 41, 45";

        Lotto expectedWinningLotto = new Lotto(List.of(1, 7, 13, 33, 41, 45));

        Lotto actualWinningLotto = lottoMachine.getWinningNumbers(winningNumbersText);

        assertThat(actualWinningLotto.getNumbers().size())
                .isEqualTo(expectedWinningLotto.getNumbers().size());
        assertThat(actualWinningLotto.getNumbers().getFirst())
                .isEqualTo(expectedWinningLotto.getNumbers().getFirst());
        assertThat(actualWinningLotto.getNumbers().getLast())
                .isEqualTo(expectedWinningLotto.getNumbers().getLast());

    }

}