package lotto;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final long prize;

    Rank(int matchCount, boolean matchBonus, long prize) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public Rank getRank(int matchCount, boolean matchBonus) {
        for (Rank rank : values()) {
            if (rank.matchCount == matchCount && rank.matchBonus == matchBonus) {
                return rank;
            }
        }
        return NONE;
    }

    public String toString(int amount) {
        if (SECOND.equals(this)) {
            return matchCount + "개 일치, 보너스 볼 일치 ("
                    + String.format("%,d", prize) + "원) - " + amount + "개";
        }
        return matchCount + "개 일치 (" + String.format("%,d", prize) + "원) - " + amount + "개";
    }
}
