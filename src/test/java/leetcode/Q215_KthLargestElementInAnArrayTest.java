package leetcode;

import org.junit.jupiter.api.Test;

class Q215_KthLargestElementInAnArrayTest {

    Q215_KthLargestElementInAnArray underTest = new Q215_KthLargestElementInAnArray();

    @Test
    void testPartition() {
        int[] nums = {7, 6, 5, 4, 3, 2, 1};
        System.out.println(underTest.findKthLargest(nums, 5));

        nums = new int[] {3,3,3,3,3};
        System.out.println(underTest.findKthLargest(nums, 5));
    }
}