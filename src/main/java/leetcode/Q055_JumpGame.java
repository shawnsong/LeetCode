package leetcode;

/*
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

 Each element in the array represents your maximum jump length at that position.

 Determine if you are able to reach the last index.

 For example:
 A = [2,3,1,1,4], return true.

 A = [3,2,1,0,4], return false. 
 */
public class Q055_JumpGame {
	public static void main(String[] arg) {
		Q055_JumpGame o = new Q055_JumpGame();
		int[] nums = {3,2,1,0,4};
		System.out.println(o.canJump(nums));
	}
	// 2, 0, 0
	public boolean canJump(int[] nums) {
		if (nums == null || nums.length <= 1)
			return true;
		
		int curEnd = nums[0];
		int nextEnd = nums[0];
		for (int i = 0; i < nums.length; i++) {
			nextEnd = Math.max(nextEnd, i + nums[i]);
			if (nextEnd >= nums.length - 1) return true;
			if (i == curEnd) {
				if (nextEnd == curEnd) return false;
				curEnd = nextEnd;
			}
		}
		return false;
	}
}
