package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTests {

    @Test
    @DisplayName("1~45사이의 중복되지 않는 6개의 숫자로 1개의 로또를 만들 수 있다.")
    void createLottoTest() {

        List<Integer> numbers = List.of(1,2,3,4,5,6);
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호의 숫자 범위가 1~45를 벗어나면 에러가 발생한다.")
    void throwWhenLottoNumberIsOutOfBounds() {

        List<Integer> numbers = List.of(0,2,3,4,5,6);
        assertThatThrownBy(
                () -> {
                    Lotto lotto = new Lotto(numbers);
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.OUT_OF_BOUNDS.getMessage());

    }

    @Test
    @DisplayName("1개의 로또에 중복되는 숫자가 있으면 에러가 발생한다.")
    void throwWhenLottoNumberDuplicate() {

        List<Integer> numbers = List.of(1,2,3,3,4,5);
        assertThatThrownBy(
                () -> {
                    Lotto lotto = new Lotto(numbers);
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.DUPLICATED_NUMBER.getMessage());

    }

    @Test
    @DisplayName("로또 번호가 6개가 아니면 에러가 발생한다.")
    void throwWhenLottoSizeIsNotSix() throws Exception {

        List<Integer> numbers = List.of(1,2,3,4,5);
        assertThatThrownBy(
                () -> {
                    Lotto lotto = new Lotto(numbers);
                }
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorCode.WRONG_LOTTO_SIZE.getMessage());

    }

}