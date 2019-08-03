package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q327_CountOfRangeSumTest {

    Q327_CountOfRangeSum test = new Q327_CountOfRangeSum();

    @Test
    void countRangeSum() {
        int[] nums = {-2,5,-1};
        assertEquals(3, test.countRangeSum(nums, -2, 2));
    }
}