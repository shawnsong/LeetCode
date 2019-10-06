package leetcode;

public class Q889_ConstructTreeFromPrePost {
    int preIdx = 0, postIdx = 0;

    public TreeNode constructFromPrePost(int[]pre, int[]post) {
        TreeNode root = new TreeNode(pre[preIdx++]);
        if (root.val != post[postIdx])
            root.left = constructFromPrePost(pre, post);
        if (root.val != post[postIdx])
            root.right = constructFromPrePost(pre, post);
        postIdx++;
        return root;
    }
}
