package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q329LongestIncreasingPathInMatrixTest {

    Q329_LongestIncreasingPathInMatrix test = new Q329_LongestIncreasingPathInMatrix();

    @Test
    void longestIncreasingPath() {
        assertEquals(2, test.longestIncreasingPath(new int[][] {{9, 6}}));
    }
}