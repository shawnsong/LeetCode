package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Q145_BinaryTreePostorderTraversalTest {

    Q145_BinaryTreePostorderTraversal underTest = new Q145_BinaryTreePostorderTraversal();

    @Test
    void postorderTraversal() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> res = underTest.postorderTraversal(root);
        assertEquals(res, Arrays.asList(3, 2, 1));
    }
}