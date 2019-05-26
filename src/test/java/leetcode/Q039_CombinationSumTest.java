package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q039_CombinationSumTest {

    Q039_CombinationSum test = new Q039_CombinationSum();

    @Test
    void combinationSum() {
        int[] nums = {2, 3, 6, 7};
        List<List<Integer>> res = test.combinationSum(nums, 7);
        assertEquals(2, res.size());
        assertTrue(Objects.equals(Arrays.asList(2, 2,3), res.get(0)) );
        assertTrue(Objects.equals(Arrays.asList(7), res.get(1)));
        System.out.println(test.combinationSum(nums, 7));
    }
}