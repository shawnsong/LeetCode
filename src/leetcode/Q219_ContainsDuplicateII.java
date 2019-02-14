package leetcode;

import java.util.HashMap;

/*
 Given an array of integers and an integer k, find out whether there are two distinct 
 indices i and j in the array such that nums[i] = nums[j] and the difference between 
 i and j is at most k.
 */
public class Q219_ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap();
		
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if (Math.abs(map.get(nums[i]) - i) <= k)
					return true;
				else
					map.put(nums[i], i);
			} else {
				map.put(nums[i], i);
			}
		}
		
		return false;
	}
}
