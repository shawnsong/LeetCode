package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/*
 Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }

Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

    You may only use constant extra space.
    You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

For example,
Given the following perfect binary tree,

         1
       /  \
      2    3
     / \  / \
    4  5  6  7

After calling your function, the tree should look like:

         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL

 */
public class Q116_PopulatingNextRightPointersInEachNode {
	public void connect(TreeLinkNode root) {
		if (root == null)
			return;
		Queue<TreeLinkNode> queue = new LinkedList();
		queue.add(root);
		while(!queue.isEmpty()) {
			Queue<TreeLinkNode> children = new LinkedList();
			TreeLinkNode fakeHead = new TreeLinkNode(0);
			TreeLinkNode pre = fakeHead;
			
			while (!queue.isEmpty()) {
				TreeLinkNode cur = queue.poll();
				pre.next = cur;
				pre = cur;
				
				if (cur.left != null)
					children.add(cur.left);
				if (cur.right != null)
					children.add(cur.right);
			}
			pre.next = null;
			
			queue = children;
		}
	}
}
