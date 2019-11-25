package leetcode;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 */
public class Q152_MaximumProductSubarray {

	public int maxProduct(int[] nums) {
        int prevMax = 1;
        int prevMin = 1;
        int res = nums[0];

        for (int num : nums) {
            int max = Math.max(num, Math.max(prevMax * num, prevMin * num));
            int min = Math.min(num, Math.min(prevMax * num, prevMin * num));
            res = Math.max(res, max);
            prevMax = max;
            prevMin = min;
        }
        return res;
	}
}
