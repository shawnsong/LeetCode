package leetcode;

/**
 * Given a binary tree, find the length of the longest consecutive sequence path.
 *
 * The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child
 * connections. The longest consecutive path need to be from parent to child (cannot be the reverse).
 *
 * For example,
 *
 *    1
 *     \
 *      3
 *     / \
 *    2   4
 *         \
 *          5
 * Longest consecutive sequence path is 3-4-5, so return 3.
 *
 *    2
 *     \
 *      3
 *     /
 *    2
 *   /
 *  1
 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
 */
public class Q298_BinaryTreeLongestConsecutiveSequence {

    private int maxLen = 0;

    public int longestConsecutive(TreeNode root) {
        traverse(root, root.val, 0);
        return maxLen;
    }

    private void traverse(TreeNode root, int prevVal, int len) {
        if (root == null) {
            return;
        }
        if (root.val == prevVal + 1) {
            len++;
        } else {
            len = 1;
        }
        maxLen = Math.max(maxLen, len);
        traverse(root.left, root.val, len);
        traverse(root.right, root.val, len);
    }
}