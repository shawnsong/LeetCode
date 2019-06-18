package leetcode;

import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q863_AllNodesDistanceKBinaryTreeTest {

    Q863_AllNodesDistanceKBinaryTree test = new Q863_AllNodesDistanceKBinaryTree();

    //
    @Test
    void distanceK() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);


        List<Integer> res = test.distanceK(root, root.left.left, 2);
        System.out.println(res);
    }
}