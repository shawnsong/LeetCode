package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q236_LowestCommonAncestorOfBinaryTreeTest {

    Q236_LowestCommonAncestorOfBinaryTree test = new Q236_LowestCommonAncestorOfBinaryTree();

    @Test
    void lowestCommonAncestor() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        assertEquals(root.left, test.lowestCommonAncestor(root, root.left, root.left.right));

        assertNull(test.lowestCommonAncestor(root, root.left.right, new TreeNode(1)));

        assertEquals(root.left, test.lowestCommonAncestor(root, root.left.left, root.left.right));
        assertEquals(root, test.lowestCommonAncestor(root, root.left.left, root.right.right));
    }
}