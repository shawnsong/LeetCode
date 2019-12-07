package leetcode.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumSwapsToSortArrayTest {
    MinimumSwapsToSortArray test = new MinimumSwapsToSortArray();

    @Test
    void minSwaps() {
        assertEquals(2, test.minSwaps(new int[] {4,3,2,1}));
        assertEquals(3, test.minSwaps(new int[] {4, 5, 2, 1, 5}));
    }
}