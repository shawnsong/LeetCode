package leetcode;

import java.util.HashSet;

/*
 Given an array of integers, find if the array contains any duplicates. 
 Your function should return true if any value appears at least twice in the array, 
 and it should return false if every element is distinct.
 */
public class Q217_ContainsDuplicate {

	public boolean containsDuplicate(int[] nums) {
		HashSet<Integer> set = new HashSet();
		
		for (int i = 0; i < nums.length; i++) {
			if (set.contains(nums[i]))
				return true;
			set.add(nums[i]);
		}
		return false;
	}
}
