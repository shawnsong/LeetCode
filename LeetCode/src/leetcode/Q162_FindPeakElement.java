package leetcode;

/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ¡Ù num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -¡Þ.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.

click to show spoilers.
Note:

Your solution should be in logarithmic complexity.

 */


public class Q162_FindPeakElement {
	
	/*
	  This problem is similar to Local Minimum. And according to the given condition, 
	  num[i] != num[i+1], there must exist a O(logN) solution. So we use binary search for this problem.

	  If num[i-1] < num[i] > num[i+1], then num[i] is peak
      If num[i-1] < num[i] < num[i+1], then num[i+1...n-1] must contains a peak
      If num[i-1] > num[i] > num[i+1], then num[0...i-1] must contains a peak
      If num[i-1] > num[i] < num[i+1], then both sides have peak (n is num.length)

	 */
	// binary search
	public int findPeakElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		return find(nums, 0, nums.length - 1);
	}
	
	public int find(int[] nums, int lo, int hi) {
		if (lo == hi)
			return lo;
		if (lo + 1 == hi) {
			return nums[lo] > nums[hi] ? lo : hi;
		}
		
		int mid = lo + (hi - lo) / 2;
		if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
			return mid;
		else if (nums[mid - 1] < nums[mid]  && nums[mid] < nums[mid + 1]) {
			int idx = find(nums, mid+1, hi);
			return idx;
		} else {
			int idx = find(nums, lo, mid-1);
			return idx;
		}
	}
	
	public static int findPeakElement1(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		
		if (nums.length == 1)
			return 0;
		for (int i = 0; i < nums.length; i++) {
			if (i == 0 && nums[i] > nums[1] || i == nums.length - 1 && nums[i] > nums[i - 1])
				return i;
			
			if (i > 0 && i <nums.length - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1])
				return i;
		}
		return -1;
	}
}
