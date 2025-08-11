package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTests {

    private LottoMachine lottoMachine = new LottoMachine();

    @Test
    @DisplayName("로또 구입 금액을 입력하면 구입 가능한 로또 개수를 반환하고 잔돈을 출력한다.")
    void getLottoAmountTest() {

        int price = 8500;

        int result = lottoMachine.getLottoAmount(price);

        assertThat(result).isEqualTo(price / 1000);

    }

    @Test
    @DisplayName("1~45 사이의 당첨 번호 6개를 입력 받아 로또를 반환할 수 있다.")
    void getWinningNumbersTest() {

        String winningNumbersText = "1, 7, 7, 13, 33, 41, 45";

        Lotto expectedWinningLotto = new Lotto(List.of(1, 7, 13, 33, 41, 45));

        Lotto actualWinningLotto = lottoMachine.setWinningNumbers(winningNumbersText);

        assertThat(actualWinningLotto.getNumbers().size())
                .isEqualTo(expectedWinningLotto.getNumbers().size());
        assertThat(actualWinningLotto.getNumbers().getFirst())
                .isEqualTo(expectedWinningLotto.getNumbers().getFirst());
        assertThat(actualWinningLotto.getNumbers().getLast())
                .isEqualTo(expectedWinningLotto.getNumbers().getLast());

    }

    @Test
    @DisplayName("입력된 당첨 번호가 1~45가 아니면 예외가 발생한다.")
    void getWinningNumbersOverRangeFailTest() {

        String wrongWinningNumbersText = "1, 7, 13, 33, 41, 88";

        assertThatThrownBy(
                () -> {
                    lottoMachine.setWinningNumbers(wrongWinningNumbersText);
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호의 숫자 범위는 1~45여야 합니다.");

    }

    @Test
    @DisplayName("입력된 당첨 번호가 6개가 아니면 예외가 발생한다.")
    void getWinningNumbersWrongSizeFailTest() {

        String wrongWinningNumbersText = "13, 33, 41, 45";

        assertThatThrownBy(
                () -> {
                    lottoMachine.setWinningNumbers(wrongWinningNumbersText);
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 6개여야 합니다.");

    }

    @Test
    @DisplayName("원하는 개수 만큼 중복되지 않는 6개의 랜덤 숫자로 이루어진 로또를 생성할 수 있다.")
    void getLottosTest() {

        int amount = 8;
        int lottoSize = 6;
        List<Lotto> lottos = lottoMachine.getLottos(amount);

        assertThat(lottos.size()).isEqualTo(amount);
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers().size()).isEqualTo(lottoSize);
        }

    }

    @Test
    @DisplayName("사용자의 로또 결과와 당첨 로또 번호를 비교한 후 Customer에 결과를 저장할 수 있다.")
    void checkLottoResultTest() {

        double earningRate = 62.5;

        lottoMachine.setWinningNumbers("1,2,3,4,5,6");
        lottoMachine.setBonusNumber(7);

        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        Customer oldCustomer = new Customer(lottos);

        Customer newCustomer = lottoMachine.checkLottoResult(oldCustomer);

        assertThat(newCustomer.getLottos().size()).isEqualTo(oldCustomer.getLottos().size());
        assertThat(newCustomer.getLottos().getFirst()).isEqualTo(oldCustomer.getLottos().getFirst());
        assertThat(newCustomer.getLottos().getLast()).isEqualTo(oldCustomer.getLottos().getLast());

        assertThat(newCustomer.getEarningRate()).isEqualTo(earningRate);
    }

}