package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q538_ConvertBSTToGreaterTreeTest {

    Q538_ConvertBSTToGreaterTree underTest = new Q538_ConvertBSTToGreaterTree();

    @Test
    void convertBST() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(13);
        root.right.right = new TreeNode(15);

        root = underTest.convertBST(root);

        assertEquals(33, root.val);
        assertEquals(39, root.left.val);
        assertEquals(28, root.right.val);
    }
}