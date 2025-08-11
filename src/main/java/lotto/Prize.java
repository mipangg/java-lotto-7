package lotto;

public enum Prize {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FORTH(50_000),
    FIFTH(5_000);

    private long prize;

    Prize(long prize) {
        this.prize = prize;
    }

    public long getPrize() {
        return prize;
    }
}
