package leetcode;

/*
 Given a binary tree, determine if it is height-balanced.

 For this problem, a height-balanced binary tree is defined as a binary tree in which 
 the depth of the two subtrees of every node never differ by more than 1. 
 */
public class Q110_BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		
		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1)
			return false;
		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1)
			return false;
		if (Math.abs(leftHeight - rightHeight) > 1)
			return false;
		return true;
	}
	
	private int checkHeight(TreeNode root) {
		if (root == null)
			return 0;
		
		int leftHeight = checkHeight(root.left);
		if (leftHeight == -1)
			return -1;
		int rightHeight = checkHeight(root.right);
		if (rightHeight == -1)
			return -1;
		if (Math.abs(leftHeight - rightHeight) > 1)
			return -1;
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
