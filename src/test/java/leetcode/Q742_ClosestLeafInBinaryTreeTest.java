package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q742_ClosestLeafInBinaryTreeTest {

    Q742_ClosestLeafInBinaryTree test = new Q742_ClosestLeafInBinaryTree();

    @Test
    void findClosestLeaf() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);

        assertEquals(3, test.findClosestLeaf(root, 1));

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.left = new TreeNode(5);
        root.left.left.left.left = new TreeNode(6);
        assertEquals(3, test.findClosestLeaf(root, 2));
    }
}