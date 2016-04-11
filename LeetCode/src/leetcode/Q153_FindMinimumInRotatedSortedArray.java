package leetcode;

/*
 Suppose a sorted array is rotated at some pivot unknown to you beforehand.

 (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

 Find the minimum element.

 You may assume no duplicate exists in the array.
 */
public class Q153_FindMinimumInRotatedSortedArray {

	public int findMin(int[] nums) {
		if (nums.length == 1) 
			return nums[0];
		int leftIdx = 0;
		int rightIdx = nums.length - 1;
		while (leftIdx <= rightIdx) {
			if (nums[leftIdx] < nums[rightIdx])
				return nums[leftIdx];
			
			if (leftIdx == rightIdx)
				return nums[leftIdx];
			
			int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
			
			if (midIdx < rightIdx && nums[midIdx] > nums[midIdx + 1])
				return nums[midIdx];
			if (midIdx > leftIdx && nums[midIdx] < nums[midIdx - 1])
				return nums[midIdx];
			
			if (nums[midIdx] > nums[leftIdx]) {// left is ordered
				leftIdx = midIdx + 1;
			} else {
				rightIdx = midIdx - 1;
			}
		}
		return -1;
	}
}
