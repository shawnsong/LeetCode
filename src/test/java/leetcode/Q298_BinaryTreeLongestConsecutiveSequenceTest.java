package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q298_BinaryTreeLongestConsecutiveSequenceTest {

    Q298_BinaryTreeLongestConsecutiveSequence test = new Q298_BinaryTreeLongestConsecutiveSequence();

    @Test
    void longestConsecutive() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(5);

        assertEquals(3, test.longestConsecutive(root));
    }
}