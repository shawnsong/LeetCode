package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1042Test {
    Q1042 test = new Q1042();

    @Test
    void gardenNoAdj() {
        int[] colors = test.gardenNoAdj(3, new int[][] {{1, 2}, {2, 3}, {3, 1}});
        assertEquals(1, colors[0]);
        assertEquals(2, colors[1]);
        assertEquals(3, colors[2]);
    }
}