package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * Given a binary tree where every node has a unique value, and a target key k, find the value of the nearest leaf node
 * to target k in the tree. Here, nearest to a leaf means the least number of edges travelled on the binary tree to
 * reach any leaf of the tree. Also, a node is called a leaf if it has no children. In the following examples, the input
 * tree is represented in flattened form row by row. The actual root tree given will be a TreeNode object.
 *
 * Example 1:
 * Input:
 * root = [1, 3, 2], k = 1
 * Diagram of binary tree:
 *           1
 *          / \
 *         3   2
 *
 * Output: 2 (or 3)
 *
 * Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.
 */
public class Q742_ClosestLeafInBinaryTree {

    public int findClosestLeaf(TreeNode root, int k) {
        if (root == null) return -1;
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode target = traverse(root, k, null, parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left == null && node.right == null) {
                return node.val;
            }
            if (node.left != null && visited.add(node.left)) {
                queue.add(node.left);
            }
            if (node.right != null && visited.add(node.right)){
                queue.add(node.right);
            }

            TreeNode parent = parentMap.get(node);
            if (parent != null && visited.add(parent)) {
                queue.add(parent);
            }
        }
        return -1;
    }

    private TreeNode traverse(TreeNode node, int target, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) return null;

        if (parent != null) {
            parentMap.put(node, parent);
        }

        if (node.val == target) return node;

        TreeNode left = traverse(node.left, target, node, parentMap);
        if (left != null) return left;
        return traverse(node.right, target, node, parentMap);
    }
}
