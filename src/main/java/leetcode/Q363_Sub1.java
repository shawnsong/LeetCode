package leetcode;

/**
 * This is the first sub-problem of 363, which is to find the max sum sub-array in a given array
 */
public class Q363_Sub1 {
    public int findMaxSum(int[] nums) {
        int cur = nums[0];
        int max = cur;
        for (int num : nums) {
            cur = Math.max(num, num + cur);
            max = Math.max(max, cur);
        }
        return max;
    }
}
