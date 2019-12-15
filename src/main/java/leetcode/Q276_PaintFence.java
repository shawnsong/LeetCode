package leetcode;

/**
 * There is a fence with n posts, each post can be painted with one of the k colors.
 *
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 *
 * Return the total number of ways you can paint the fence.
 */
public class Q276_PaintFence {
    public int numWays(int n, int k) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return k;
        } else if (n == 2) {
            return k * k;
        }
        int prevDiff = k * (k - 1);
        int prevSame = k;

        for (int i = 2; i < n; i++){
            int curDiff = (prevDiff + prevSame) * (k - 1);
            int curSame = prevDiff;

            prevDiff = curDiff;
            prevSame = curSame;
        }
        return prevDiff + prevSame;
    }
}
