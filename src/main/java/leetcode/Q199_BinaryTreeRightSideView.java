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
		dfsGetView(root, rightSideView, 1);
		return rightSideView;
	}
	
	public void dfsGetView(TreeNode root, ArrayList<Integer> view, int level) {
		if (root == null)
			return;
		
		if (level > view.size()) {
			view.add(root.val);
		}
		dfsGetView(root.right, view, level+1);
		dfsGetView(root.left, view, level+1);
	}
}
