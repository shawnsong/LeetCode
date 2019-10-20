package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q363_Sub1Test {
    Q363_Sub1 test = new Q363_Sub1();

    @Test
    void findMaxSum() {
        int[] nums = {1, -1, -2, 2, -1, 3};
        assertEquals(4, test.findMaxSum(nums));
        nums = new int[] {-2, 9, -3, 4};
        assertEquals(10, test.findMaxSum(nums));
    }
}