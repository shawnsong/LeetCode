package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q039_SubsetSumTest {
    Q039_SubsetSum test = new Q039_SubsetSum();

    @Test
    void hasSubset() {
        assertTrue(test.hasSubset(new int[] {2,3,7,8,10}, 2));
        assertTrue(test.hasSubset(new int[] {2,3,7,8,10}, 5));
        assertTrue(test.hasSubset(new int[] {2,3,7,8,10}, 10));
        assertTrue(test.hasSubset(new int[] {2,3,7,8,10}, 11));
        assertTrue(test.hasSubset(new int[] {2,3,7,8,10}, 15));
        assertTrue(test.hasSubset(new int[] {2,3,7,8,10}, 20));
        assertTrue(test.hasSubset(new int[] {2,3,7,8,10}, 18));
    }

    @Test
    void numberOfSubset() {
        int[] nums = {2, 2, 3, 4, 6, 8, 10};
        assertEquals(1, test.numberOfSubsets(nums, 3));
        assertEquals(2, test.numberOfSubsets(nums, 5));
        assertEquals(2, test.numberOfSubsets(nums, 4));
        assertEquals(3, test.numberOfSubsets(nums, 6));
        // 2 6, 2 6, 2 2 4, 8
        assertEquals(4, test.numberOfSubsets(nums, 8));
    }
}