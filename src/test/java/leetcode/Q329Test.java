package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q329Test {

    Q329 test = new Q329();

    @Test
    void longestIncreasingPath() {
        assertEquals(2, test.longestIncreasingPath(new int[][] {{9, 6}}));
    }
}