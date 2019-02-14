package leetcode;

import java.util.LinkedList;
import java.util.List;

/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.

OJ's Binary Tree Serialization:

The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:

   1
  / \
 2   3
    /
   4
    \
     5

The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}". 
 */
public class Q095_UniqueBinarySearchTreesII {
	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> res = generate(1, n);
		return res;
	}
	
	private List<TreeNode> generate(int start, int end) {
		List<TreeNode> res = new LinkedList();
		if (start > end) {
			res.add(null);
			return res;
		}
		
		if (start == end) {
			TreeNode root = new TreeNode(start);
			res.add(root);
			return res;
		}
		
		for (int i = start; i <= end; i++) {
			List<TreeNode> left = generate(start, i - 1);
			List<TreeNode> right = generate(i + 1, end);
			
			for (TreeNode l : left) {
				for (TreeNode r: right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root);
				}
			}
		}
		return res;
	}
}
