package leetcode;

/*
 Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

 Note: 
 You may assume k is always valid, 1 �� k �� BST's total elements.

 Follow up:
 What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
 How would you optimize the kthSmallest routine?

 Hint:

 Try to utilize the property of a BST.
 What if you could modify the BST node's structure?
 The optimal runtime complexity is O(height of BST).

 */
public class Q230_KthSmallestElementInBST {
	int count = 0;
	int num = 0;
	public int kthSmallest(TreeNode root, int k) {
		inorder(root, k);
		return num;
	}
	
	public void inorder(TreeNode root, int k) {
		if (root == null)
			return;
		inorder(root.left, k);
		count++;
		if (count == k) {
			num = root.val;
			return;
		}
		inorder(root.right, k);
	}
}
