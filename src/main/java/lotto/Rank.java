package lotto;

public enum Rank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FORTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private int matchCount;
    private boolean isBonus;
    private long prize;

    Rank(int matchCount, boolean isBonus, long prize) {
        this.matchCount = matchCount;
        this.isBonus = isBonus;
        this.prize = prize;
    }

    public static Rank getRank(int matchCount, boolean isBonus) {
        for (Rank rank : Rank.values()) {
            if (rank.matchCount == matchCount && rank.isBonus == isBonus) {
                return rank;
            }
        }
        return NONE;
    }

    public long getPrize() {
        return prize;
    }

    public String toString(int lottoCount) {
        if (this.equals(SECOND)) {
            return matchCount + "개 일치, 보너스 볼 일치 (" + String.format("%,d", prize) + "원) - " + lottoCount + "개";
        }
        return matchCount + "개 일치 (" + String.format("%,d", prize) + "원) - " + lottoCount + "개";
    }
}
