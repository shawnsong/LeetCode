package leetcode;

/*
After robbing those houses on that street, the thief has found himself a new place for his thievery 
so that he will not get too much attention. This time, all houses at this place are arranged in a circle. 
That means the first house is the neighbor of the last one. Meanwhile, the security system for these 
houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the 
maximum amount of money you can rob tonight without alerting the police.
 */
public class Q213_HouseRobberII {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		else if (nums.length == 1) {
			return nums[0];
		}

		int dp1 = 0;
		int dp2 = 0;
		
		int prev2 = 0;
		int prev1 = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			dp1 = Math.max(prev1, prev2 + nums[i]);
			prev2 = prev1;
			prev1 = dp1;
		}

		prev2 = 0;
		prev1 = 0;
		for (int i = 1; i < nums.length; i++) {
			dp2 = Math.max(prev1, prev2 + nums[i]);
			prev2 = prev1;
			prev1 = dp2;
		}

		return Math.max(dp1, dp2);
	}
}
