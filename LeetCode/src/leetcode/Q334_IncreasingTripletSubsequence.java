package leetcode;

/*
 Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.

Formally the function should:

    Return true if there exists i, j, k
    such that arr[i] < arr[j] < arr[k] given 0 ¡Ü i < j < k ¡Ü n-1 else return false. 

Your algorithm should run in O(n) time complexity and O(1) space complexity.

Examples:
Given [1, 2, 3, 4, 5],
return true.

Given [5, 4, 3, 2, 1],
return false. 
 */
public class Q334_IncreasingTripletSubsequence {

	public boolean increasingTriplet(int[] nums) {
		if (nums == null || nums.length < 3)
			return false;

		int[] dp = new int[3];
		dp[0] = nums[0];
		int len = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > dp[len - 1]) {
				dp[len] = nums[i];
				len++;
				if (len == 3)
					return true;
			} else {
				if (nums[i] <= dp[0])
					dp[0] = nums[i];
				else if (nums[i] <= dp[1])
					dp[1] = nums[i];
			}
		}
		return false;
	}

	public boolean increasing(int[] nums) {
		if (nums.length < 3)
			return false;

		int min = nums[0];
		int mid = Integer.MAX_VALUE;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= min) {
				min = nums[i];
			} else if (nums[i] <= mid) {
				mid = nums[i];
			} else
				return true;
		}
		return false;
	}
}
