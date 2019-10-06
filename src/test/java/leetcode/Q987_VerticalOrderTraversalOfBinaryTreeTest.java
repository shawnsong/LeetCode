package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Q987_VerticalOrderTraversalOfBinaryTreeTest {
    Q987_VerticalOrderTraversalOfBinaryTree test = new Q987_VerticalOrderTraversalOfBinaryTree();

    @Test
    void verticalTraversal() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
//        System.out.println(test.verticalTraversal(root));
        assertEquals(Arrays.asList(
                Arrays.asList(9),
                Arrays.asList(3, 15),
                Arrays.asList(20),
                Arrays.asList(7)
        ), test.verticalTraversal(root));
    }
}