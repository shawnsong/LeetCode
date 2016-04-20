package leetcode;

/*
 Given an array of size n, find the majority element. The majority element is the element 
 that appears more than n/2 times.
 You may assume that the array is non-empty and the majority element always exist in the array.
 */

public class Q169_MajorityElement {

	// moore's voting algorithm
	public int majorityElement(int[] nums) {
		if (nums == null || nums.length == 0)
			return -1;
		int num = nums[0];
		int vote = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == num)
				vote++;
			else
				vote--;
			if (vote == 0) {
				num = nums[i];
				vote = 1;
			}
		}
		
		return num;
	}
	
}
