package leetcode;

import java.util.ArrayList;

public class Q662_MaxTreeWidth {
    public int widthOfBinaryTree(TreeNode root) {
        return traverse(root, 0, 0, new ArrayList<>(), new ArrayList<>());
    }

    private int traverse(TreeNode node, int level, int order, ArrayList<Integer> starts, ArrayList<Integer> ends) {
        if (node == null) return 0;

        if (level == starts.size()) {
            starts.add(order);
            ends.add(order);
        } else {
            if (order < starts.get(level)) {
                starts.set(level, order);
            }
            if (order > ends.get(level)) {
                ends.set(level, order);
            }
        }
        int cur = ends.get(level) - starts.get(level) + 1;
        int left = traverse(node.left, level + 1, order * 2 + 1, starts, ends);
        int right = traverse(node.right, level + 1, order * 2 + 2, starts, ends);

        return Math.max(cur, Math.max(left, right));
    }
}
