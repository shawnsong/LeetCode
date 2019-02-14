package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class Q179_LargestNumber {

	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0)
			return "";

		String[] numsStr = new String[nums.length];
		for (int i = 0; i < numsStr.length; i++)
			numsStr[i] = String.valueOf(nums[i]);
		
		Arrays.sort(numsStr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				
			
				String ss1 = s1 + s2;
				String ss2 = s2 + s1;
				return ss2.compareTo(ss1);
			}
		});
		
		if (numsStr[0].equals("0"))
			return "0";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numsStr.length; i++)
			sb.append(numsStr[i]);
		return sb.toString();
				
	}
}
