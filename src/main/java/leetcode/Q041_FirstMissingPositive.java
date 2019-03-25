package leetcode;

/*
 * 
 *  Given an unsorted integer array, find the first missing positive integer. 
 *  For example.
 *  Given [1,2,0] return 3,
 *  and [3,4,-1,1] return 2.
 *  
 *  Your algorithm should run in O(n) time and uses constant space.
 */
public class Q041_FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			int idx = nums[i];

			if (idx < 0 || idx > nums.length || idx - 1 == i)
				continue;

			if (idx - 1 != nums[i]) {
				swap(nums, idx, i);
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] - 1 != i)
				return i + 1;
		}

		return nums.length + 1;
	}
	
	private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];;
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
