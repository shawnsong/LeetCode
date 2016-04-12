package leetcode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class Q103_BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new LinkedList();
		if (root == null)
			return res;
		ArrayDeque<TreeNode> queue = new ArrayDeque();
		queue.add(root);
		int level = 1;
		while (!queue.isEmpty()) {
			ArrayDeque<TreeNode> children = new ArrayDeque();
			List<Integer> list = new LinkedList();
			while (!queue.isEmpty()) {
				TreeNode n = queue.poll();
				if (level % 2 == 1) {
					list.add(n.val);
				} else {
					list.add(0, n.val);
				}
				if (n.left != null)
					children.add(n.left);
				if (n.right != null)
					children.add(n.right);
			}
			res.add(list);
			queue = children;
			level++;
		}

		return res;
	}
}
