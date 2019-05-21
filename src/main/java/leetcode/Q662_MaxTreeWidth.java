package leetcode;

import java.util.ArrayList;

public class Q662_MaxTreeWidth {
    public int widthOfBinaryTree(TreeNode root) {
        return traverse(root, 0, 0, new ArrayList(), new ArrayList());
    }

    int traverse(TreeNode root, int level, int order, ArrayList<Integer> start, ArrayList<Integer> end) {
        if (root == null) return 0;

        if (level == start.size()) {
            start.add(level);
            end.add(level);
        } else {
            if (order < start.get(level)) {
                start.set(level, order);
            }
            if (order > end.get(level)) {
                end.set(level, order);
            }
        }
        int cur = end.get(level) - start.get(level) + 1;

        int left = traverse(root.left, level + 1, order * 2 + 1, start, end);
        int right = traverse(root.right, level+1, order * 2 + 2, start, end);

        return Math.max(cur, Math.max(left, right));
    }
}
