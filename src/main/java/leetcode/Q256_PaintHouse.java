package leetcode;

/**
 * There are a row of n houses, each house can be painted with one of the three colors: red, blue or green.
 * You have to paint all the houses such that no two adjacent houses have the same color.
 *
 * Input: [[17,2,17],[16,16,5],[14,3,19]]
 * Output: 10
 * Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
 *              Minimum cost: 2 + 5 + 3 = 10.
 */
public class Q256_PaintHouse {
    public int minCost(int[][] costs) {
        int r = 0, g = 0, b = 0;
        for (int[] cost : costs) {
            int rr = r, gg = g, bb = b;
            r = Math.min(gg, bb) + cost[0];
            g = Math.min(rr, bb) + cost[1];
            b = Math.min(gg, rr) + cost[2];
        }
        return Math.min(r, Math.min(g, b));
    }
}
