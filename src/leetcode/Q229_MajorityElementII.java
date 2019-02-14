package leetcode;

import java.util.LinkedList;
import java.util.List;

/*
 * Given an integer array of size n, find all elements that appear more than (n / 3) times. 
 * The algorithm should run in linear time and in O(1) space.
 */
public class Q229_MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> res = new LinkedList();
		
		if (nums.length == 0) {
			return res;
		}
		
		int num1 = 0;
		int num2 = 1;
		
		int count1 = 0;
		int count2 = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == num1)
				count1++;
			else if (nums[i] == num2)
				count2++;
			else if (count1 == 0) {
				num1 = nums[i];
				count1 = 1;
			} else if (count2 == 0) {
				num2 = nums[i];
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}
		
		count1 = 0;
		count2 = 0;
		for (int i = 0; i< nums.length; i++) {
			if (num1 == nums[i])
				count1++;
			if (num2 == nums[i])
				count2++;
		}
		
		if (count1 > nums.length / 3)
			res.add(num1);
		if (count2 > nums.length / 3)
			res.add(num2);
		return res;
	}
}
