package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.ErrorCode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTests {

    @Test
    @DisplayName("로또 1개와 보너스 번호 1개를 당첨번호로 저장할 수 있다")
    void createWinningLottoTest() {

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;

        WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
        Lotto savedWinningLotto = winningLotto.getWinningLotto();

        assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);
        for (Integer number : lotto.getNumbers()) {
            assertThat(savedWinningLotto.contains(number)).isTrue();
        }

    }

    @Test
    @DisplayName("보너스 번호는 당첨 번호와 중복될 수 없다")
    void throwWhenBonusNumberDuplicateWinningNumbers() {

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 6;

        assertThatThrownBy(
                () -> {
                    WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DUPLICATE_NUMBER.getMessage());

    }

    @Test
    @DisplayName("보너스 번호가 1~45 범위를 벗어날 경우 에러가 발생한다")
    void throwWhenBonusNumberIsOutOfBounds() {

        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 100;

        assertThatThrownBy(
                () -> {
                    WinningLotto winningLotto = new WinningLotto(lotto, bonusNumber);
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.OUT_OF_BOUNDS.getMessage());

    }

    @Test
    @DisplayName("당첨 번호도 일반 로또와 같은 검증을 거친다")
    void validateWinningLottoLikeRegularLotto() {

        int bonusNumber = 7;

        assertThatThrownBy(
                () -> {
                    WinningLotto winningLotto = new WinningLotto(
                            new Lotto(List.of(1,2,3,4,5,6,7)),
                            bonusNumber
                    );
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.WRONG_LOTTO_SIZE.getMessage());
    }

}