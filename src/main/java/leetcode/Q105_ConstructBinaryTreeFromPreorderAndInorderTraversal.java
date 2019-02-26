package leetcode;

public class Q105_ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }

        return buildTree(0, 0, preorder.length - 1, preorder, inorder);
    }

    private TreeNode buildTree(int preStartIdx, int inStartIdx, int inEndIdx, int[] preorder, int[] inorder) {
        if (preStartIdx == inorder.length) {
            return null;
        }

        if (inStartIdx > inEndIdx) {
            return null;
        }
        if (inStartIdx == inEndIdx) {
            return new TreeNode(inorder[inStartIdx]);
        }

        TreeNode root = new TreeNode(preorder[preStartIdx]);

        int idx = inStartIdx;
        for (; idx <= inEndIdx; idx++) {
            if (inorder[idx] == root.val) {
                break;
            }
        }

        root.left = buildTree(preStartIdx + 1, inStartIdx, idx - 1, preorder, inorder);
        root.right = buildTree(preStartIdx + idx - inStartIdx  + 1, idx + 1, inEndIdx, preorder, inorder);
        return root;
    }
}
