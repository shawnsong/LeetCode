package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q802_FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new LinkedList<>();
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(graph, i, color)) {
                res.add(i);
            }
        }
        return res;
    }

    boolean dfs(int[][] graph, int node, int[] color) {
        if (color[node] != 0) {
            return color[node] == 1;
        }
        color[node] = 2;
        int[] nexts = graph[node];
        for (int next : nexts) {
            if (!dfs(graph, next, color)) {
                return false;
            }
        }
        color[node] = 1;
        return true;
    }
}
