package leetcode;

/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class Q111_MinimumDepthOfBinaryTree {

	private int minDepth = Integer.MAX_VALUE;

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		minDepth(root, 1);
		return minDepth;
	}

	public void minDepth(TreeNode root, int level) {
		if (root == null)
			return;

		if (level > minDepth)
			return;

		if (root.left == null && root.right == null) {
			minDepth = Math.min(level, minDepth);
			return;
		}

		minDepth(root.left, level + 1);
		minDepth(root.right, level + 1);
	}
}
