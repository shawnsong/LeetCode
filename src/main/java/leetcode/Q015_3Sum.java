package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 *  Find all unique triplets in the array which gives the sum of zero.
 *
 *  Note: The solution set must not contain duplicate triplets.
 *
 *  For example, given array S = [-1, 0, 1, 2, -1, -4],
 *
 *  A solution set is:
 *  [
 *  [-1, 0, 1],
 *  [-1, -1, 2]
 *  ]
 */
public class Q015_3Sum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new LinkedList();
		if (nums == null || nums.length < 3)
			return res;
		
		Arrays.sort(nums);
		
        for (int start = 0; start < nums.length - 2; start++) {
            if (start > 0 && nums[start] == nums[start - 1]) {
                continue;
            }

            int left = start + 1;
            int right = nums.length - 1;
            int target = 0 - nums[start];

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    res.add(Arrays.asList(nums[start], nums[left], nums[right]));
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return res;
	}
}
