package leetcode;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q314_BinaryTreeVerticalOrderTraversalTest {

    Q314_BinaryTreeVerticalOrderTraversal test = new Q314_BinaryTreeVerticalOrderTraversal();

    /**
     *      3
     *     /\
     *    /  \
     *    9   8
     *   /\  /\
     *  /  \/  \
     *  4  01   7
     */
    @Test
    void verticalOrder() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);

        List<List<Integer>> res = test.verticalOrder(root);
        assertEquals(Arrays.asList(
            Arrays.asList(4),
            Arrays.asList(9),
            Arrays.asList(3, 0, 1),
            Arrays.asList(8),
            Arrays.asList(7)
            ), res);
    }
}