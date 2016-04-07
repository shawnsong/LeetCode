package leetcode;

/*
 Given an array of integers, every element appears three times except for one. Find that single one.

 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Q137_SingleNumberII {
	public int singleNumber(int[] nums) {
		int[] bitCount = new int[32];
		
		for (int i = 0; i < nums.length; i++) {
			
			int num = nums[i];
			for (int j = 0; j < 32; j++) {
				int b = 1 << j;
				if ((num & b) != 0)
					bitCount[31 - j]++;
			}
		}
		
		int res = 0;
		for (int i = 31; i >= 0; i--) {
			if (bitCount[i] % 3 != 0) {
				res = res | (1 << (31 - i));
			}
		}
		return res;
	}
}
