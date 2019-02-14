package leetcode;

/*
Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to 
the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space 
for the purpose of space complexity analysis.)
 */
public class Q238_ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums) {

		int[] res = new int[nums.length];
		for (int i = 0; i < res.length; i++)
			res[i] = 1;

		int leftProduct = 1;
		int rightProduct = 1;

		for (int i = 1; i < nums.length; i++) {
			leftProduct = leftProduct * nums[i-1];
			res[i] = res[i] * leftProduct;
			
		}

		for (int i = nums.length - 2; i >= 0; i--) {
			rightProduct = rightProduct * nums[i + 1];
			res[i] = res[i] * rightProduct;
		}
		return res;
	}
}
