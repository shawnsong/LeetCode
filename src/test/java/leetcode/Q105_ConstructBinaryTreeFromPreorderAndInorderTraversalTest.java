package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q105_ConstructBinaryTreeFromPreorderAndInorderTraversalTest {
    Q105_ConstructBinaryTreeFromPreorderAndInorderTraversal test = new Q105_ConstructBinaryTreeFromPreorderAndInorderTraversal();

    @Test
    void testBuild() {
        int[] preorder = {4,1,2,3};
        int[] inorder = {1,2,3,4};
        TreeNode tree = test.buildTree(preorder, inorder);
    }
}