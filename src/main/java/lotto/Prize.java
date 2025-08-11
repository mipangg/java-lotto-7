package lotto;

public enum WinningRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FORTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    private int count;
    private boolean isBonus;
    private long prize;

    WinningRank(int count, boolean isBonus, long prize) {
        this.count = count;
        this.isBonus = isBonus;
        this.prize = prize;
    }
}
