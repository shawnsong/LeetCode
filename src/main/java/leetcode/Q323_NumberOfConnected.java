package leetcode;

public class Q323_NumberOfConnected {
    public int countComponents(int n, int[][] edges) {
        if (n <= 0 || edges == null || edges.length == 0) {
            return 0;
        }
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }

        int count = n;
        for (int[] edge : edges) {
            int root1 = edge[0];
            int root2 = edge[1];
            root1 = findRoot(roots, root1);
            root2 = findRoot(roots, root2);
            if (root1 != root2) {
                roots[root2] = root1;
                count--;
            }
        }
        return count;
    }

    private int findRoot(int[] roots, int node) {
        while (roots[node] != node) {
            node = roots[node];
        }
        return node;
    }
}
