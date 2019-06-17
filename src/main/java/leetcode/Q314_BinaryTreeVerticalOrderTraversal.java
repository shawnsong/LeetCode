package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q314_BinaryTreeVerticalOrderTraversal {

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNodeLevel> queue = new LinkedList<>();
        queue.add(new TreeNodeLevel(root, 0));
        int minLevel = 0;
        while (!queue.isEmpty()) {
            TreeNodeLevel nodeLevel = queue.poll();
            int level = nodeLevel.level;
            TreeNode node = nodeLevel.node;
            if (level < minLevel) {
                res.add(0, new LinkedList<>());
                minLevel = level;
            }
            if (level - minLevel == res.size()) {
                res.add(new LinkedList<>());
            }
            res.get(level - minLevel).add(node.val);
            if (node.left != null) {
                queue.add(new TreeNodeLevel(node.left, level - 1));
            }
            if (node.right != null) {
                queue.add(new TreeNodeLevel(node.right, level + 1));
            }
        }
        return res;
    }

    class TreeNodeLevel {
        TreeNode node;
        int level;

        public TreeNodeLevel(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
