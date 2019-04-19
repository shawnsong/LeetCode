package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */
public class Q199_BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		ArrayList<Integer> rightSideView = new ArrayList();
		traverse(root, 0, rightSideView);
		return rightSideView;
	}
	
	private void traverse(TreeNode root, int level, List<Integer> res) {
		if (root == null) return;

		if (level == res.size()) {
			res.add(root.val);
		}

		traverse(root.right, level + 1, res);
		traverse(root.left, level + 1, res);
	}
}
