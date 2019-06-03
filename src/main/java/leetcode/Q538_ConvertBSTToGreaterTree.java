package leetcode;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is
 * changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *                    \
 *                     15
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 */
public class Q538_ConvertBSTToGreaterTree {

    public TreeNode convertBST(TreeNode root) {
        int[] sum = new int[1];
        convert(root, sum);
        return root;
    }

    private void convert(TreeNode node, int[] sum) {
        if (node == null) return;
        convert(node.right, sum);
        node.val += sum[0];
        sum[0] = node.val;
        convert(node.left, sum);
    }

//    public TreeNode convertBST(TreeNode root) {
//        if (root == null) return null;
//        sum(root, 0);
//        return root;
//    }
//
//    private int sum(TreeNode node, int preSum) {
//        if (node == null) return 0;
//
//        int right = sum(node.right, preSum);
//        node.val += right + preSum;
//        int left = sum(node.left, node.val);
//
//        return node.val - preSum + left;
//    }
}
