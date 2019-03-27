package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q039_CombinationSumTest {

    Q039_CombinationSum test = new Q039_CombinationSum();

    @Test
    void combinationSum() {
        int[] nums = {2, 3, 6, 7};
        System.out.println(test.combinationSum(nums, 7));
    }
}