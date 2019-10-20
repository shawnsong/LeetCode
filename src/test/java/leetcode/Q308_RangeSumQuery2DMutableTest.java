package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q308_RangeSumQuery2DMutableTest {


    @Test
    void sumRegion() {
        int[][] m = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        Q308_RangeSumQuery2DMutable test = new Q308_RangeSumQuery2DMutable(m);
        assertEquals(8, test.sumRegion(2, 1, 4, 3));
        test.update(3, 2, 2);
        assertEquals(10, test.sumRegion(2, 1, 4, 3));
    }
}