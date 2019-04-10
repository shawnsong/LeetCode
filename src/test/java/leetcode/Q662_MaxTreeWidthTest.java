package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q662_MaxTreeWidthTest {

    Q662_MaxTreeWidth test = new Q662_MaxTreeWidth();

    @Test
    void widthOfBinaryTree() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);

        root.right.right = new TreeNode(9);

        assertEquals(4, test.widthOfBinaryTree(root));
    }
}