package leetcode;

//Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

public class Q108_ConvertSortedArrayToBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0)
			return null;
		
		TreeNode root = buildBST(nums, 0, nums.length - 1);
		return root;
	}
	
	private TreeNode buildBST(int[] nums, int leftIdx, int rightIdx) {
		if (leftIdx > rightIdx)
			return null;
		int midIdx = leftIdx + (rightIdx - leftIdx) / 2;
		TreeNode root = new TreeNode(nums[midIdx]);
		
		root.left = buildBST(nums, leftIdx, midIdx - 1);
		root.right = buildBST(nums, midIdx + 1, rightIdx);
		
		return root;
	}
}
