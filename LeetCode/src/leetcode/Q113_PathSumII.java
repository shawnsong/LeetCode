package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
For example:
Given the below binary tree and sum = 22,

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

return

[
   [5,4,11,2],
   [5,8,4,5]
]

 */
public class Q113_PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new LinkedList();
		sum(root, sum, res, new ArrayList());
		return res;
	}
	
	private void sum(TreeNode root, int sum, List<List<Integer>> res, ArrayList<Integer> path) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			if (sum == root.val) {
				List<Integer> list = new LinkedList();
				list.addAll(path);
				list.add(root.val);
				res.add(list);
			}
			return;
		}
		path.add(root.val);
		sum(root.left, sum - root.val, res, path);
		sum(root.right, sum - root.val, res, path);
		path.remove(path.size() - 1);
	}
}
