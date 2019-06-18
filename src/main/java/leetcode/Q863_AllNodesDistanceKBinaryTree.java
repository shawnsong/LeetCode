package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * We are given a binary tree (with root node root), a target node, and an integer value K.
 *
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 */
public class Q863_AllNodesDistanceKBinaryTree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);
        traverse(root, null, parentMap);
        if (!parentMap.containsKey(target)) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);

        while (!queue.isEmpty()) {
            if (k == 0) {
                while (!queue.isEmpty()) {
                    res.add(queue.poll().val);
                }
                break;
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && visited.add(node.left)) {
                    queue.add(node.left);
                }
                if (node.right != null && visited.add(node.right)) {
                    queue.add(node.right);
                }
                TreeNode parent = parentMap.get(node);
                if (parent != null && visited.add(parent)) {
                    queue.add(parent);
                }
            }
            k--;
        }

        return res;
    }

    private void traverse(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if (node == null) {
            return;
        }

        if (parent != null) {
            parentMap.put(node, parent);
        }

        traverse(node.left, node, parentMap);
        traverse(node.right, node, parentMap);
    }
}
