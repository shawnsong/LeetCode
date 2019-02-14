package leetcode;

/*
 Given an array of numbers nums, in which exactly two elements appear only once and all the other 
 elements appear exactly twice. Find the two elements that appear only once.

 For example:

 Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

 Note:
 The order of the result is not important. So in the above example, [5, 3] is also correct.
 Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class Q260_SingleNumberIII {
	public int[] singleNumber(int[] nums) {
		int xor = 0;
		for (int i = 0; i < nums.length; i++)
			xor ^= nums[i];
		
		int c = 1;
		while ((c & xor) == 0)
			c = c << 1;
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if ((nums[i] & c) == 0){
				res[0] = res[0] ^ nums[i];
			} else {
				res[1] = res[1] ^ nums[i];
			}
		}
		return res;
	}
}
