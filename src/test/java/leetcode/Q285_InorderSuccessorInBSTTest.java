package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q285_InorderSuccessorInBSTTest {

    Q285_InorderSuccessorInBST test = new Q285_InorderSuccessorInBST();
    @Test
    void inorderSuccessor() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);

        assertEquals(7, test.inorderSuccessor(root, new TreeNode(6)).val);
        assertEquals(null, test.inorderSuccessor(root, new TreeNode(8)));
    }
}