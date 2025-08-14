package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Customer {
    private final List<Lotto> lottos;
    private Map<Rank, Integer> result;
    private double earningRate;

    public Customer(List<Lotto> lottos) {
        this.lottos = lottos;
        initResult();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public double getEarningRate() {
        return earningRate;
    }

    public void setResult(WinningLotto winningLotto) {
        for (Lotto lotto : lottos) {
            int matchCount = winningLotto.getMatchCount(lotto);
            boolean matchBonus = false;

            if (matchCount == 5) {
                matchBonus = winningLotto.matchBonus(lotto);
            }
            Rank rank = Rank.getRank(matchCount, matchBonus);
            this.result.put(rank, result.get(rank) + 1);
        }
    }

    public void setEarningRate() {
        BigDecimal cost = BigDecimal.valueOf(lottos.size() * 1000L);
        BigDecimal totalPrize = Rank.getTotalPrize(result);
        earningRate = totalPrize.divide(cost, 2, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .doubleValue();
    }

    public String getTotalResult() {
        StringBuilder totalResult = new StringBuilder();

        totalResult.append(Rank.FIFTH.toString(result.get(Rank.FIFTH))).append("\n");
        totalResult.append(Rank.FOURTH.toString(result.get(Rank.FOURTH))).append("\n");
        totalResult.append(Rank.THIRD.toString(result.get(Rank.THIRD))).append("\n");
        totalResult.append(Rank.SECOND.toString(result.get(Rank.SECOND))).append("\n");
        totalResult.append(Rank.FIRST.toString(result.get(Rank.FIRST)));

        return totalResult.toString();
    }

    public String getTotalEarningRate() {
        return "총 수익률은 " + earningRate + "%입니다.";
    }

    private void initResult() {
        result = new HashMap<>();
        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.FIFTH, 0);
        result.put(Rank.NONE, 0);
    }

}
