package leetcode;

/*
 Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?

 Write a function to determine if a given target is in the array.
 */
public class Q081_SearchInRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		return search(nums, target, 0, nums.length - 1);
	}
	
	public boolean search(int[] nums, int t, int lowIdx, int highIdx) {
		if (lowIdx > highIdx) {
			return false;
		}
		
		int midIdx = lowIdx + (highIdx - lowIdx) / 2;
		
		if (nums[midIdx] == t)
			return true;
		
		if (nums[midIdx] < nums[highIdx]) { // right is ordered
			if (nums[midIdx] <= t && t <= nums[highIdx]) {
				// search right
				return search(nums, t, midIdx + 1, highIdx);
			} else {
				// search left
				return search(nums, t, lowIdx, midIdx - 1);
			}
		} else if (nums[midIdx] > nums[highIdx]) {
			// left is ordered
			if (nums[lowIdx] <= t && t <= nums[midIdx]) {
				// search left
				return search(nums, t, lowIdx, midIdx - 1);
			} else {
				// search right
				return search(nums, t, midIdx + 1, highIdx);
			}
		} else if (nums[midIdx] == nums[highIdx]) {
			if (nums[midIdx] != nums[lowIdx])
				return search(nums, t, lowIdx, midIdx - 1);
			// search both sides
			boolean res = search(nums, t, midIdx + 1, highIdx);
			if (res == true)
				return true;
			else
				return search(nums, t, lowIdx, midIdx - 1);
		}
		return false;
	}
}
