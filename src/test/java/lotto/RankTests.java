package lotto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTests {

    @Test
    @DisplayName("Rank enum 테스트")
    void rankTest() {

        Rank first = Rank.getRank(6, false);
        System.out.println(first.toString(0));

        Rank second = Rank.getRank(5, true);
        System.out.println(second.toString(0));

        Rank third = Rank.getRank(5, false);
        System.out.println(third.toString(0));

        Rank fourth = Rank.getRank(4, false);
        System.out.println(fourth.toString(1));

        Rank fifth = Rank.getRank(3, false);
        System.out.println(fifth.toString(2));

    }

}