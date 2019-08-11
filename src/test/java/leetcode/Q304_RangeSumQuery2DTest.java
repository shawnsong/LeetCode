package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q304_RangeSumQuery2DTest {

    @Test
    void sumRegion() {

        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        Q304_RangeSumQuery2D test = new Q304_RangeSumQuery2D(matrix);
        assertEquals(8, test.sumRegion(2, 1, 4, 3));
        assertEquals(11, test.sumRegion(1, 1, 2, 2));
    }
}