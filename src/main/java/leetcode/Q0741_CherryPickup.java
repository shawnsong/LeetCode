package leetcode;

/**
 * In a N x N grid representing a field of cherries, each cell is one of three possible integers.
 *     0 means the cell is empty, so you can pass through;
 *     1 means the cell contains a cherry, that you can pick up and pass through;
 *     -1 means the cell contains a thorn that blocks your way.
 */
public class Q0741_CherryPickup {
  public int cherryPickup(int[][] grid) {
    int n = grid.length;
    return Math.max(0, pickup(grid, n, 0, 0, 0, 0, new Integer[n][n][n][n]));
  }

  int pickup(int[][] grid, int n, int r1, int c1, int r2, int c2, Integer[][][][] cache) {
    if (r1 == n || c1 == n || r2 == n || c2 == n || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
      return Integer.MIN_VALUE;
    }
    if (cache[r1][c1][r2][c2] != null) {
      return cache[r1][c1][r2][c2];
    }
    if (r1 == n-1 && c1 == n-1) {
      return grid[r1][c1];
    }
    if (r2 == n-1 && c2 == n-1) {
      return grid[r2][c2];
    }
    int res = grid[r1][c1] + grid[r2][c2];
    if (r1 == r2 && c1 == c2) {
      res = grid[r1][c1];
    }
    res += Math.max(
        Math.max(pickup(grid, n, r1+1, c1, r2+1, c2, cache), pickup(grid, n, r1+1, c1, r2, c2 + 1, cache)),
        Math.max(pickup(grid, n, r1, c1 + 1, r2+1, c2, cache), pickup(grid, n, r1, c1 + 1, r2, c2 + 1, cache))
    );
    cache[r1][c1][r2][c2] = res;
    return res;
  }
}
