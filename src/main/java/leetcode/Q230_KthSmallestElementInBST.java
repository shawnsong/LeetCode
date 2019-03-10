package leetcode;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 */
public class Q230_KthSmallestElementInBST {
	int count = 0;
	int num = 0;

    public int kthSmallest(TreeNode root, int k) {
        int leftCount = count(root.left);
        if (k <= leftCount) {
            return kthSmallest(root, k);
        } else if (k > leftCount + 1) {
            return kthSmallest(root.right, k - leftCount - 1);
        }
        // k == leftCount + 1
        return root.val;
    }

    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }

	public int kthSmallest2(TreeNode root, int k) {
		inorder(root, k);
		return num;
	}
	
	private void inorder(TreeNode root, int k) {
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
