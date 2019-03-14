package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q280_WiggleSortTest {

    Q280_WiggleSort test = new Q280_WiggleSort();

    @Test
    void wiggleSort() {
        int[] nums = {4, 3, 2, 1};
        test.wiggleSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}