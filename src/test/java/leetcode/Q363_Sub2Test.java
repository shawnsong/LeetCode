package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q363_Sub2Test {
    Q363_Sub2 test = new Q363_Sub2();

    @Test
    void findMaxSumSubMatrix() {
        int[][] matrix = {
                {2, 1, -3,-4, 5},
                {0, 6,  3, 4, 1},
                {2,-2, -1, 4,-5},
                {-3,3,  1, 0, 3}
        };
        assertEquals(18, test.findMaxSumSubMatrix(matrix));
    }

    @Test
    void findMaxSumSubArray() {
        int[] nums = {1, -1, -2, 2, -1, 3, -3, 7};
        assertEquals(8, test.findMaxSumSubArray(nums));
    }
}