package leetcode;

/*
 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 For example,
 Given nums = [0, 1, 3] return 2.

 Note:
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity? 
 */
public class Q268_MissingNumber {

	public int missingNumber(int[] nums) {
		if (nums.length <= 2)
			return 0;
		int sum = 0;

		for (int i = 0; i < nums.length; i++)
			sum += nums[i];

		int n = nums.length;
		return (int) (n + 1) * n / 2 - sum;
	}
}
