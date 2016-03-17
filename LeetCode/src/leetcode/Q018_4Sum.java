package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target 
 Find all unique quadruplets in the array which gives the sum of target.

 Note:
 Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ¡Ü b ¡Ü c ¡Ü d)
 The solution set must not contain duplicate quadruplets.
 For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

 A solution set is:
 (-1,  0, 0, 1)
 (-2, -1, 1, 2)
 (-2,  0, 0, 2)
 */

public class Q018_4Sum {

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		int i;
		int j;
		List<List<Integer>> ret = new ArrayList();
		for (i = 0; i < nums.length; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (j = nums.length - 1; j > i + 2; j--) {
				if (j < nums.length - 1 && nums[j] == nums[j + 1])
					continue;
				int start = i + 1;
				int end = j - 1;

				while (start < end) {
					int sum = nums[i] + nums[j] + nums[start] + nums[end];
					if (sum == target) {
						List<Integer> ans = new LinkedList();
						ans.add(nums[i]);
						ans.add(nums[start]);
						ans.add(nums[end]);
						ans.add(nums[j]);
						ret.add(ans);

						start++;
						while (start < end && nums[start] == nums[start - 1])
							start++;

						end--;
						while (start < end && nums[end] == nums[end + 1])
							end--;
					} else if (sum < target) {
						start++;
					} else
						end--;
				}
			}

		}

		return ret;
	}
}
