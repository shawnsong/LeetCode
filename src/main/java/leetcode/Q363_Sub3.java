package leetcode;

import java.util.TreeSet;

public class Q363_Sub3 {
    public int findMaxSubArrayNoLargeThanK(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);

        int sum = 0;
        int res = Integer.MIN_VALUE;
        for(int num : nums) {
            sum += num;

            // we want something no larger than k, something <= k
            // sum - x <= k
            // so x >= sum - k but not too large
            Integer subSum = set.ceiling(sum - k);
            if (subSum != null) {
                res = Math.max(res, sum - subSum);
            }
        }
        return res;
    }
}
