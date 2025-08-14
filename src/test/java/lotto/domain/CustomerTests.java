package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTests {

    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(1, 3, 5, 7, 9, 11)),
                        new Lotto(List.of(1, 10, 20, 30, 40, 45))
                )
        );
    }

    @Test
    @DisplayName("당첨 번호와 손님의 로또를 비교하여 당첨 결과를 저장할 수 있다")
    void setResultTest() {

        WinningLotto winningLotto = new WinningLotto(List.of(1,2,3,4,5,6), 7);
        Map<Rank, Integer> expectedResult = Map.of(
                Rank.FIRST, 1,
                Rank.SECOND, 1,
                Rank.THIRD, 0,
                Rank.FOURTH, 0,
                Rank.FIFTH, 1,
                Rank.NONE, 1
        );

        customer.setResult(winningLotto);
        Map<Rank, Integer> actualResult = customer.getResult();
        assertThat(expectedResult.get(Rank.FIRST)).isEqualTo(actualResult.get(Rank.FIRST));
        assertThat(expectedResult.get(Rank.SECOND)).isEqualTo(actualResult.get(Rank.SECOND));
        assertThat(expectedResult.get(Rank.THIRD)).isEqualTo(actualResult.get(Rank.THIRD));
        assertThat(expectedResult.get(Rank.FOURTH)).isEqualTo(actualResult.get(Rank.FOURTH));
        assertThat(expectedResult.get(Rank.FIFTH)).isEqualTo(actualResult.get(Rank.FIFTH));
        assertThat(expectedResult.get(Rank.NONE)).isEqualTo(actualResult.get(Rank.NONE));

    }
}