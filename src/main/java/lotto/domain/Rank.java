package lotto.domain;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Map.Entry;

public enum Rank {
    FIRST(6, false, BigDecimal.valueOf(2000000000)),
    SECOND(5, true, BigDecimal.valueOf(30000000)),
    THIRD(5, false, BigDecimal.valueOf(1500000)),
    FOURTH(4, false, BigDecimal.valueOf(50000)),
    FIFTH(3, false, BigDecimal.valueOf(5000)),
    NONE(0, false, BigDecimal.ZERO);

    private final int matchCount;
    private final boolean matchBonus;
    private final BigDecimal prize;

    Rank(int matchCount, boolean matchBonus, BigDecimal prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static Rank getRank(int matchCount, boolean matchBonus) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return NONE;
    }

    public static BigDecimal getTotalPrize(Map<Rank, Integer> result) {
        BigDecimal totalPrize = BigDecimal.ZERO;
        for (Entry<Rank, Integer> entry : result.entrySet()) {
            totalPrize = totalPrize.add(
                    entry.getKey().prize
                    .multiply(new BigDecimal(entry.getValue())
                    )
            );
        }
        return totalPrize;
    }

    public String toString(int amount) {
        DecimalFormat formatter = new DecimalFormat("###,###.##");

        if (SECOND.equals(this)) {
            return matchCount + "개 일치, 보너스 볼 일치 ("
                    + formatter.format(prize) + "원) - " + amount + "개";
        }
        return matchCount + "개 일치 (" + formatter.format(prize) + "원) - " + amount + "개";
    }
}
