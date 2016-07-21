package leetcode;

/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

Example 1:

    2
   / \
  1   3

Binary tree [2,1,3], return true.

Example 2:

    1
   / \
  2   3

Binary tree [1,2,3], return false. 
 */
public class Q098_ValidateBinarySearchTree {
	
	public static void main(String[] args) {
		Q098_ValidateBinarySearchTree o = new Q098_ValidateBinarySearchTree();
		TreeNode r = new TreeNode(Integer.MAX_VALUE);
		
		System.out.println(o.isValidBST(r));
	}

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
		if (root == null)
			return true;
		if (root.val <= minValue || root.val >= maxValue)
			return false;

		boolean validLeft = isValidBST(root.left, minValue, root.val);
		if (!validLeft)
			return false;
		return isValidBST(root.right, root.val, maxValue);
	}
}
