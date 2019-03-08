package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q209_MinimumSizeSubarraySumTest {

    Q209_MinimumSizeSubarraySum underTest = new Q209_MinimumSizeSubarraySum();

    @Test
    void minSubArrayLen() {
        assertEquals(2, underTest.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
    }
}