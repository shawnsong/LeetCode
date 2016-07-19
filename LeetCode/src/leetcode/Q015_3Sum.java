package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
 Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]

 */
public class Q015_3Sum {
	
	public static void main(String[] ar) {
		Q015_3Sum o = new Q015_3Sum();
		int nums[] = {-2,0,0,2,2};
		System.out.println(o.threeSum(nums));
	}
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ret = new LinkedList();
		if (nums == null || nums.length < 3)
			return ret;
		
		Arrays.sort(nums);
		
		int n = nums.length;
		
		for (int k = 0; k < n - 2; k++) {
			if (k > 0 && nums[k] == nums[k - 1])
				continue;
			int i = k + 1;
			int j = nums.length - 1;
			
			while (i < j) {
				int target = 0 - nums[k];
				int sum = nums[i] + nums[j];
				if (sum < target) {
					i++;
				} else if (sum > target) {
					j--;
				} else {
					List<Integer> tmp = new LinkedList();
					tmp.add(nums[k]);
					tmp.add(nums[i]);
					tmp.add(nums[j]);
					ret.add(tmp);
					
					while (j > i && nums[j] == nums[j - 1])
						j--;
					i++;
					j--;
				}
			}
		}
		
		return ret;
	}
}
