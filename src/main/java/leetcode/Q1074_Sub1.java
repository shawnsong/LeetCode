package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Number of sub-array that sum to a target
 */
public class Q1074_Sub1 {
    public int numOfSubArray(int[] nums, int target) {
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            int remain = sum - target;
            if (preSum.containsKey(remain)) {
                count += preSum.get(remain);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
