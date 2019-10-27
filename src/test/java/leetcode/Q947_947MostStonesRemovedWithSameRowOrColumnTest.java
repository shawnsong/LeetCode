package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q947_947MostStonesRemovedWithSameRowOrColumnTest {
    Q947_947MostStonesRemovedWithSameRowOrColumn test = new Q947_947MostStonesRemovedWithSameRowOrColumn();

    @Test
    void removeStones() {
        assertEquals(5, test.removeStones(new int[][] {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}}));
        assertEquals(0, test.removeStones(new int[][] {{0, 0}}));
    }
}