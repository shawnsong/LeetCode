package leetcode;

/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
 3 4
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25. 
 */
public class Q129_SumRootToLeafNumbers {
	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		return sum(root, 0);
	}
	
	public int sum(TreeNode root, int num) {
		if (root == null)
			return 0;
		// this is a leaf
		if (root.left == null && root.right == null) {
			int sum = num * 10 + root.val;
			return sum;
		}
		
		int sum = sum(root.left, num * 10 + root.val) + sum(root.right, num * 10 + root.val);
		
		return sum;
	}
}
