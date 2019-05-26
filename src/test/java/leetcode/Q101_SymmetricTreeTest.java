package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q101_SymmetricTreeTest {

    Q101_SymmetricTree test = new Q101_SymmetricTree();

    @Test
    void isSymmetricTree() {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode( 2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = root.left.right;
        root.right.right = root.left.left;

        assertTrue(test.isSymmetricTree(root));
    }
}