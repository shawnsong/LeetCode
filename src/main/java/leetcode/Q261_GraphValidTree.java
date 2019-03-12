package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Q261_GraphValidTree {

    public boolean validTree(int n, int[][] edges) {
        int[] inDegree = new int[n];
        ArrayList<Integer>[] children = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int root = edges[i][0];
            int child = edges[i][1];
            inDegree[child]++;
            children[root].add(child);
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
                count++;
                if (count > 1) {
                    return false;
                }
            }
            if (inDegree[i] > 1) {
                return false;
            }
        }
        count = 1;
        while(!queue.isEmpty()) {
            int root = queue.poll();
            for (int child : children[root]) {
                inDegree[child]--;
                if (inDegree[child] == 0) {
                    count++;
                    queue.offer(child);
                }
            }
        }
        return count == n;
    }
}