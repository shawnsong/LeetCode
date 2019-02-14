package leetcode;

import java.util.Stack;

/*
 Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

 Calling next() will return the next smallest number in the BST.

 Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree
 */
public class Q173_BinarySearchTreeIterator {
	private Stack<TreeNode> stack = null;

	public Q173_BinarySearchTreeIterator(TreeNode root) {
		stack = new Stack<TreeNode>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		if (!stack.isEmpty()) {
			TreeNode root = stack.pop();
			int ret = root.val;

			root = root.right;
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			return ret;
		} else {
			return -1;
		}
	}
}
