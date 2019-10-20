package leetcode;

public class Q776_SplitBST {
    TreeNode[] splitBST(TreeNode root, int v) {
        TreeNode[] res = new TreeNode[2];
        if (root == null) {
            return res;
        }
        if (root.val <= v) {
            res[0] = root;
            TreeNode[] splits = splitBST(root.right, v);
            root.right = splits[0];
            res[1] = splits[1];
        } else {
            res[1] = root;
            TreeNode[] splits = splitBST(root.left, v);
            root.left = splits[1];
            res[0] = splits[0];
        }
        return res;
    }
}
