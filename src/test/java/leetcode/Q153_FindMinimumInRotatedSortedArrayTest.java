package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q153_FindMinimumInRotatedSortedArrayTest {

    Q153_FindMinimumInRotatedSortedArray underTest = new Q153_FindMinimumInRotatedSortedArray();

    @Test
    void findMin() {
        assertEquals(1, underTest.findMin(new int[] {2, 1}));
        assertEquals(1, underTest.findMin(new int[] {3, 1, 2}));
        assertEquals(1, underTest.findMin(new int[] {1, 2, 3}));
    }
}