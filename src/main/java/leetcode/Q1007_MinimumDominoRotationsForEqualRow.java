package leetcode;

public class Q1007_MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        if (A.length != B.length) {
            return -1;
        }
        int len = A.length;
        int[] countA = new int[7];
        int[] countB = new int[7];
        int[] same = new int[7];
        for (int i = 0; i < len; i++) {
            int a = A[i], b = B[i];
            countA[a]++;
            countB[b]++;
            if (a == b) {
                same[a]++;
            }
        }

        int res = len;
        for (int i = 1; i < 7; i++) {
            if (countA[i] + countB[i] - same[i] == len) {
                int tmp = Math.min(countA[i], countB[i]) - same[i];
                res = Math.min(tmp, res);
            }
        }
        return res == len ? -1 : res;
    }
}
