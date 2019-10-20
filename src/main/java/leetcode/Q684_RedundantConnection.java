package leetcode;

public class Q684_RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] roots = new int[edges.length + 1];
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }

        for (int[] edge : edges) {
            int x = findRoot(roots, edge[0]);
            int y = findRoot(roots, edge[1]);
            if (x != y) {
                roots[x] = y;
            } else {
                return edge;
            }
        }
        return new int[2];
    }

    int findRoot(int[] roots, int node) {
        while (roots[node] != node) {
            node = roots[node];
        }
        return node;
    }
}
