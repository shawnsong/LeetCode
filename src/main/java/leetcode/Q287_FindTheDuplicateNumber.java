package leetcode;

/**
 *  Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 *  prove that at least one duplicate number must exist. Assume that there is only one duplicate number,
 *  find the duplicate one.
 *
 *  Note:
 *  You must not modify the array (assume the array is read only).
 *  You must use only constant, O(1) extra space.
 *  Your runtime complexity should be less than O(n2).
 *  There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class Q287_FindTheDuplicateNumber {
	public int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[slow];

		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
			fast = nums[fast];
		}
		fast = 0;
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
}
