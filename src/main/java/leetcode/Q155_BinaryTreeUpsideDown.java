package leetcode;

public class Q155_BinaryTreeUpsideDown {
    public TreeNode upsideDown(TreeNode root) {
        if (root == null || (root.left == null && root.right == null) ) {
            return root;
        }

        TreeNode newRoot = upsideDown(root.left);
        newRoot.left= root.right;
        newRoot.right = root;
        return newRoot;
    }

}
