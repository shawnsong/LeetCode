package leetcode;

import java.util.*;

public class Q987_VerticalOrderTraversalOfBinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, PriorityQueue<ValLevel>> map = new TreeMap<>();
        traverse(root, map, 0, 0);
        List<List<Integer>> res = new LinkedList<>();
        for (Map.Entry<Integer, PriorityQueue<ValLevel>> entry : map.entrySet()) {
            List<Integer> line = new LinkedList<>();
            PriorityQueue<ValLevel> pq = entry.getValue();
            while (!pq.isEmpty()) {
                line.add(pq.poll().val);
            }
            res.add(line);
        }
        return res;
    }

    void traverse(TreeNode root, TreeMap<Integer, PriorityQueue<ValLevel>> map, int level, int col) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(col, new PriorityQueue<>((v1, v2) -> {
            if (v1.level != v2.level) {
                return v1.level - v2.level;
            }
            return v1.val - v2.val;
        }));
        map.get(col).add(new ValLevel(root.val, level));
        traverse(root.left, map, level + 1, col - 1);
        traverse(root.right, map, level + 1, col + 1);
    }

    class ValLevel {
        int val;
        int level;
        ValLevel(int v, int l) {
            val = v;
            level = v;
        }
    }
}
