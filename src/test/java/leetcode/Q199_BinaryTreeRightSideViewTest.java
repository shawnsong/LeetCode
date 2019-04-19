package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q199_BinaryTreeRightSideViewTest {

    Q199_BinaryTreeRightSideView test = new Q199_BinaryTreeRightSideView();

    @Test
    void rightSideView() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(5);

        System.out.println(test.rightSideView(root));
    }
}