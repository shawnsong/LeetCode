package leetcode;

public class Q1066_CampusBikesII {

    int min = Integer.MAX_VALUE;

    public int assignBikes(int[][] workers, int[][] bikes) {
        dfs(workers, bikes, new boolean[bikes.length], 0, 0);
        return min;
    }

    private void dfs(int[][] workers, int[][] bikes, boolean[] used, int count, int sum) {
        if (count == bikes.length) {
            min = Math.min(sum, min);
            return;
        }

        if (sum > min) {
            return;
        }

        for (int i = 0; i < bikes.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            int dist = dist(workers[count], bikes[i]);
            dfs(workers, bikes, used, count+1, sum + dist);
            used[i] = false;
        }
    }

    private int dist(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
}
