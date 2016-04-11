package leetcode;

/*
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 
 Follow up for "Remove Duplicates": 
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
 It doesn't matter what you leave beyond the new length. 
 */
public class Q080_RemoveDuplicatesFromSortedArrayII {
	public static void main(String[] a) {
		Q080_RemoveDuplicatesFromSortedArrayII o = new Q080_RemoveDuplicatesFromSortedArrayII();
		int[] nums = {1,1,1,1,2,2,3};
		o.removeDuplicates(nums);

		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i]);
	}
	//[1,1,1,1,2,2,3]
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int count = 1;
		int j = 0;
		int sameCount = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[j]) {
				if (sameCount == 1) {
					j++;
					nums[j] = nums[i];
					sameCount++;
				} else {
					continue;
				}
			} else {
				j++;
				nums[j] = nums[i];
				sameCount = 1;
			}
			count++;
		}
		return count;
	}
}
