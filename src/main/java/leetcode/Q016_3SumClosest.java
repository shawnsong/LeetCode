package leetcode;

import java.util.Arrays;

/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 */
public class Q016_3SumClosest {
	public static void main(String[] a) {
		Q016_3SumClosest o = new Q016_3SumClosest();
		int[] nums = {1,1,1,1};
		int res = o.threeSumClosest(nums, 1);
		System.out.println(res);
		
	}
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		
		int diff = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length -2; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			
			while (start < end) {
				
				int tmpSum = nums[i] + nums[start] + nums[end];
				if (tmpSum == target)
					return target;
				else {
					
					if (Math.abs(tmpSum - target) < diff) {
						sum = tmpSum;
						diff = Math.abs(tmpSum - target);
					}
					if (nums[i] + nums[start] > target && nums[start] > 0)
						break;
					if (nums[i] + nums[end] < target && nums[end] < 0)
						break;
					if (tmpSum < target)
						start++;
					else
						end--;
				}
			}
		}
		
		return sum;
	}
}
