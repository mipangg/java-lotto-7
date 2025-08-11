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
        initWinnings();
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
        winnings.put(rank, winnings.get(rank) + 1);
    }

    public void setEarningRate() {
        if (!lottos.isEmpty()) {
            this.earningRate = Math.round((double) getTotalEarning() / lottos.size()) / 10.0;
        }
    }

    private long getTotalEarning() {
        long totalEarnings = 0;
        for (Rank rank : winnings.keySet()) {
            totalEarnings += rank.getPrize() * winnings.get(rank);
        }
        return totalEarnings;
    }

    private void initWinnings() {
        winnings.put(Rank.FIRST, 0);
        winnings.put(Rank.SECOND, 0);
        winnings.put(Rank.THIRD, 0);
        winnings.put(Rank.FOURTH, 0);
        winnings.put(Rank.FIFTH, 0);
        winnings.put(Rank.NONE, 0);
    }
}
