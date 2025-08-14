package lotto.app;

import lotto.domain.Lotto;

public class Application {

    public static void main(String[] args) {
        LottoStore store = new LottoStore();
        store.enter();
    }
}
