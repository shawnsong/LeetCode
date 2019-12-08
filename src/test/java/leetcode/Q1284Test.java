package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1284Test {
    Q1284 test = new Q1284();

    @Test
    void minFlips() {
        assertEquals(3, test.minFlips(new int[][] {{0, 0}, {0, 1}}));
        assertEquals(6, test.minFlips(new int[][] {{0, 0}, {0, 1}}));
    }

    @Test
    void flip() {
    }

    @Test
    void testToString() {
    }
}