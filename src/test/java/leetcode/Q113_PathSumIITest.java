package leetcode;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q113_PathSumIITest {

    Q113_PathSumII test = new Q113_PathSumII();

    @Test
    void pathSum() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        List<List<Integer>> res = test.pathSum(root, 22);
        assertEquals(2, res.size());
        assertEquals(4, res.get(0).size());
        assertEquals(4, res.get(1).size());
        System.out.println(res);
    }
}