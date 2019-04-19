package leetcode;

public class Q101_SymmetricTree {

    public boolean isSymmetricTree(TreeNode root) {
        if (root == null) return true;

        return isSymmetric(root.right, root.left);
    }

    private boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) return node1 == node2;

        if (node1.val != node2.val) return false;

        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }
}
