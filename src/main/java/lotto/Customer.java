package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    private List<Lotto> lottos;
    private Map<Rank, Integer> winnings = new HashMap<>();
    private double earningRate;

    public Customer(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Rank, Integer> getWinnings() {
        return winnings;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public void updateWinnings(int matchCount, boolean isBonus) {
        Rank rank = Rank.getRank(matchCount, isBonus);
        winnings.put(rank, winnings.getOrDefault(rank, 0) + 1);
    }

    public void setEarningRate() {
        this.earningRate = Math.round(((float) lottos.size() / getTotalEarnings()) * 100) / 100.0;
    }

    private long getTotalEarnings() {
        long totalEarnings = 0;
        for (Rank rank : winnings.keySet()) {
            totalEarnings += rank.getPrize() * winnings.get(rank);
        }
        return totalEarnings;
    }
}
