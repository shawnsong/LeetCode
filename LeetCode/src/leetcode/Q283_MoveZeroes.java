package leetcode;

/*
 Given an array nums, write a function to move all 0's to the end of it while maintaining 
 the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 */
public class Q283_MoveZeroes {

	public void moveZeroes(int[] nums) {
		int i = 0;
		int j = 0;

		while (i < nums.length) {
			if (nums[i] != 0) {
				nums[j] = nums[i];
				j++;
			}
			i++;
		}

		while (j < nums.length) {
			nums[j] = 0;
			j++;
		}
	}
}
