package leetcode;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray
 * of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class Q209_MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int left = 0, right = 0;
		int sum = 0;
		int len = nums.length + 1;
		while (right < nums.length) {
		    sum += nums[right];
		    right++;
		    while (sum >= s) {
                len = Math.min(len, right - left);
		        sum -= nums[left];
		        left++;
            }
        }
		return len == nums.length + 1 ? 0 : len;
	}
}
