package leetcode;

public class Q685_RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] can1 = {-1, -1};
        int[] can2 = {-1, -1};

        int[] roots = new int[edges.length + 1];
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            if (roots[child] == 0) {
                roots[child] = parent;
            } else {
                // the child already has father
                // the newest link
                can2 = edge;
                // the older version of link
                can1 = new int[] {roots[child], child};
                // set the current link invalid
                edge[1] = -1;
            }
        }
        for (int i = 0; i < roots.length; i++) {
            roots[i] = i;
        }
        for (int[] edge : edges) {
            // current link is not valid
            if (edge[1] == -1) {
                continue;
            }
            int parent = edge[0];
            int child = edge[1];
            if (findRoot(roots, parent) == child) {
                if (can1[0] == -1) {
                    return edge;
                } else {
                    return can1;
                }
            }
            roots[child] = parent;
        }
        return can2;
    }
    int findRoot(int[] roots, int node) {
        while (roots[node] != node) {
            node = roots[node];
        }
        return node;
    }
}
