package leetcode;

public class Q351_AndroidUnlockPatterns {

    public int numberOfPatterns(int m, int n) {
        // skip[1][3] means from 1 to 3 need to skip 2
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = skip[8][2] = skip[3][7] = skip[7][3] =
                skip[4][6] = skip[6][4] = 5;

        int res = 0;
        boolean[] visited = new boolean[10];
        for (int i = m; i <= n; i++) {
            res += dfs(visited, skip, 1, i - 1) * 4;
            res += dfs(visited, skip, 2, i - 1) * 4;
            res += dfs(visited, skip, 5, i - 1);
        }
        return res;
    }

    private int dfs(boolean[] visited, int[][] skip, int cur, int remain) {
        if (remain == 0) {
            return 1;
        }

        int res = 0;
        visited[cur] = true;
        for (int i = 1; i <= 9; i++) {
            if (visited[i]) {
                continue;
            }
            // if cannot skip, e.g: from 1 to 3 and skip[cur][i] which is 2 has not been visited
            if (skip[cur][i] != 0 && !visited[skip[cur][i]]) {
                continue;
            }
            res += dfs(visited, skip, i, remain - 1);
        }
        visited[cur] = false;
        return res;
    }
}
