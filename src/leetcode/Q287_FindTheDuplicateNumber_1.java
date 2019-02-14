package leetcode;

/*
 Given an array nums containing n + 1 integers where each integer is between 0 and n-1 (inclusive), 
 prove that at least one duplicate number must exist. Assume that there is only one duplicate number, 
 find the duplicate one.

 Note:
 You must not modify the array (assume the array is read only).
 You must use only constant, O(1) extra space.
 Your runtime complexity should be less than O(n2).
 There is only one duplicate number in the array, but it could be repeated more than once.

 */
public class Q287_FindTheDuplicateNumber_1 {
	public static void main(String[] args) {
		int[] nums = {0, 0, 2, 1};
		Q287_FindTheDuplicateNumber_1 o = new Q287_FindTheDuplicateNumber_1();
		int i = o.findDuplicate(nums);
		System.out.println(i);
	}
	
	public int findDuplicate(int[] nums) {
		int n = nums.length;
		int slow = nums[n - 1];
		int fast = nums[n - 1];
		
		while(true) {
			slow = nums[slow];
			fast = nums[nums[fast]];
			if (slow == fast)
				break;
		}
		slow = nums[n - 1];
		while (slow != fast) {
			slow = nums[slow];
			fast = nums[fast];
		}
		return slow;
	}
}
