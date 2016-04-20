package leetcode;

/*
 Given an array of n positive integers and a positive integer s, find the minimal length of a 
 subarray of which the sum ¡Ý s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7,
 the subarray [4,3] has the minimal length under the problem constraint.

 click to show more practice.

 More practice:
 If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 */
public class Q209_MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		
		int i = 0;
		int j = 0;
		int sum = 0;
		int len = nums.length;
		while (j <= nums.length) {
			while (sum >= s) {
				len = Math.min(len, j - i);
				sum = sum - nums[i];
				i++;
			}
			if (j == nums.length)
				break;
			sum += nums[j];
			j++;

		}
		return len;
	}
}
