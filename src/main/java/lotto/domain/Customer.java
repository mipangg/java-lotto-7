package lotto.domain;

import java.util.List;
import java.util.Map;

public class Customer {
    private List<Lotto> lottos;
    private Map<Rank, Integer> result;
    private double earningRate;

    public Customer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

}
