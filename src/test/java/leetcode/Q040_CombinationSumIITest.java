package leetcode;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q040_CombinationSumIITest {

    Q040_CombinationSumII test = new Q040_CombinationSumII();

    @Test
    void combinationSum2() {
        int[] nums = {10,1,2,7,6,1,5};
        List<List<Integer>> res = test.combinationSum2(nums, 8);
        assertEquals(4, res.size());
        System.out.println(res);
    }
}