package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q802_FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new LinkedList<>();
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (isSafe(graph, i, color) == 1) {
                res.add(i);
            }
        }
        return res;
    }

    int isSafe(int[][] graph, int node, int[] color) {
        if (color[node] != 0) {
            return color[node];
        }
        color[node] = 2;
        int[] nexts = graph[node];
        for (int next : nexts) {
            if (isSafe(graph, next, color) == 2) {
                return 2;
            }
        }
        color[node] = 1;
        return 1;
    }
}
