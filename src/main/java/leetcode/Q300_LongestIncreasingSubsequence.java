package leetcode;

/**
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 *
 *  For example,
 *  Given [10, 9, 2, 5, 3, 7, 101, 18],
 *  The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
 *  Note that there may be more than one LIS combination, it is only necessary for you to return the length.
 *
 *  Your algorithm should run in O(n2) complexity.
 *
 *  Follow up: Could you improve it to O(n log n) time complexity?
 */
public class Q300_LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		
		int len = 1;
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] <= dp[len - 1]) {
				int idx = findInsertionIdx(dp, len, nums[i]);
				dp[idx] = nums[i];
			} else {
				dp[len] = nums[i];
				len++;
			}
		}
		return len;
	}
	
	private int findInsertionIdx(int[] dp, int len, int t) {
		int low = 0;
		int high = len - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (dp[mid] == t)
				return mid;
			else if (dp[mid] < t) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}
}
