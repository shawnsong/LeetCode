package leetcode;

import java.util.HashMap;

/*
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class Q001_TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap();
		int[] ret = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int remain = target - nums[i];
			if (map.containsKey(remain)) {
				ret[0] = map.get(remain);
				ret[1] = i;
				break;
			} else {
				map.put(nums[i], i);
			}
		}
		
		return ret;
	}
}
