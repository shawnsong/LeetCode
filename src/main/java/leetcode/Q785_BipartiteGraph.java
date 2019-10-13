package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q785_BipartiteGraph {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0 && !isValid(graph, i, 1, colors)) {
                return false;
            }
        }
        return true;
    }

    boolean isValid(int[][] graph, int idx, int color, int[] colors) {
        if (colors[idx] != 0) {
            return colors[idx] == color;
        }

        colors[idx] = color;
        for (int next : graph[idx]) {
            if (!isValid(graph, next, -color, colors)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBipartiteBfs(int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            Queue<Integer> queue = new LinkedList<>();
            colors[i] = 1;
            queue.add(i);

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {
                        colors[next] = -colors[cur];
                        queue.add(next);
                    } else {
                        if (colors[next] == colors[cur]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
