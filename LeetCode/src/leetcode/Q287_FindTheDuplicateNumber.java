package leetcode;

public class Q287_FindTheDuplicateNumber {
	public static void main(String[] ar) {
		Q287_FindTheDuplicateNumber o = new Q287_FindTheDuplicateNumber();
		
		int[] nums = {1, 3,2,3};
		int n = o.findDuplicate(nums);
		System.out.println(n);
	}
	public int findDuplicate(int[] nums) {
		int slow = nums[0];
		int fast = nums[0];
		
		while (true) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			if (slow == fast)
				break;
		}
		
		slow = nums[0];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		
		return slow;
	}
}
