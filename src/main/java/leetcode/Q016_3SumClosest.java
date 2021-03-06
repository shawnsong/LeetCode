package leetcode;

import java.util.Arrays;

/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 */
public class Q016_3SumClosest {

	public int threeSumClosest(int[] nums, int target) {


        if (nums == null || nums.length < 3) {
            return 0;
        }

        int minDiff = Integer.MAX_VALUE;
        int res = 0 ;

        Arrays.sort(nums);
        for (int start = 0; start < nums.length - 2; start++) {
            if (start > 0 && nums[start] == nums[start - 1]) {
                continue;
            }

            int left = start + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[start] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }

                int diff = Math.abs(target - sum);
                if (diff < minDiff) {
                    res = sum;
                    minDiff = diff;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }
}
