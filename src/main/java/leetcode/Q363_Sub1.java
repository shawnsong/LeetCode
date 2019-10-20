package leetcode;

/**
 * This is the first sub-problem of 363, which is to find the max sum sub-array in a given array
 */
public class Q363_Sub1 {
    public int findMaxSum(int[] nums) {
        int maxSoFar = nums[0];
        int max = maxSoFar;
        for (int i = 1; i < nums.length; i++) {
            int cur = Math.max(maxSoFar + nums[i], nums[i]);
            max = Math.max(cur, max);
            maxSoFar = cur;
        }
        return max;
    }
}
