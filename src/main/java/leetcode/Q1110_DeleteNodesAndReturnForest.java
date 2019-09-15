package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Q1110_DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] toDelete) {
        Set<Integer> vals = new HashSet<>();
        for (int d : toDelete) {
            vals.add(d);
        }
        List<TreeNode> res = new LinkedList<>();
        traverse(root, true, vals, res);
        return res;
    }

    TreeNode traverse(TreeNode node, boolean isRoot, Set<Integer> vals, List<TreeNode> res) {
        if (node == null) {
            return null;
        }
        boolean deleted = vals.contains(node.val);
        node.left = traverse(node.left, deleted, vals, res);
        node.right = traverse(node.right, deleted, vals, res);
        if (isRoot && !deleted) {
            res.add(node);
        }
        return deleted ? null : node;
    }
}
