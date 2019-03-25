package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q053_MaximumSubarrayTest {

    @Test
    void maxSubArray() {
        Q053_MaximumSubarray o = new Q053_MaximumSubarray();
        int[] nums = {-1, -2};
        assertEquals(-1, o.maxSubArray(nums));

    }
}