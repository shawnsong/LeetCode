package leetcode.monotonicqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q496_NextGreaterElementITest {
    Q496_NextGreaterElementI test = new Q496_NextGreaterElementI();

    @Test
    void nextGreaterElement() {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        assertArrayEquals(new int[] {-1, 3, -1}, test.nextGreaterElement(nums1, nums2));
    }
}