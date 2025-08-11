package lotto;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ClerkTests {

    private final Clerk clerk = new Clerk();

    @Test
    @DisplayName("로또를 어떻게 출력하는지 확인하기 위한 테스트")
    void printLottosTest() {

        List<Lotto> lottos = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42))
        );
        clerk.printLottos(lottos);

    }

}