package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"]. 
 */
public class Q228_SummaryRanges {
	public static void main(String[] a) {
		List<String> res = summaryRanges(new int[]{1,3,5,7});
		System.out.println(res);
	}
	
	public static List<String> summaryRanges(int[] nums) {
		if (nums.length == 0)
			return new LinkedList();
		int rangeStart = nums[0];
		
		int prev = nums[0];
		List<String> res = new LinkedList();
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - prev == 1) {
				prev = nums[i];
			} else {
				if (prev == rangeStart) {
					res.add(String.valueOf(rangeStart));
				} else {
					res.add(String.valueOf(rangeStart) + "->" + prev);
				}
				prev = nums[i];
				rangeStart = nums[i];
			}
		}
		if (prev == rangeStart) {
			res.add(String.valueOf(rangeStart));
		} else {
			res.add(String.valueOf(rangeStart) + "->" + prev);
		}
		
		return res;
	}
}
