package leetcode;

/*
 Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

 Note:
 You are not suppose to use the library's sort function for this problem.

 click to show follow up.

 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

 Could you come up with an one-pass algorithm using only constant space?

 */
public class Q075_SortColors {
	public void sortColors1(int[] nums) {
		if (nums == null || nums.length < 2) {
			return;
		}
		int zeroIdx = 0;
		int oneIdx = 0;
		int twoIdx = nums.length - 1;
		
		while (oneIdx <= twoIdx) {
			if (nums[oneIdx] == 0) {
				swap(nums, zeroIdx, oneIdx);
				zeroIdx++;
				oneIdx++;
			} else if (nums[oneIdx] == 2) {
				swap(nums, twoIdx, oneIdx);
				twoIdx--;
			} else {
				oneIdx++;
			}
		}
	}

	public void sortColors2(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int left = 0, right = nums.length - 1;
        for (int i = 0; i <= right; i++) {
            if (nums[i] == 2) {
                swap(nums, i, right);
                i--;
            } else if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
            }
        }
    }

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
