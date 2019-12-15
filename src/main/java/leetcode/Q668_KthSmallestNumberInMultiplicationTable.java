package leetcode;

public class Q668_KthSmallestNumberInMultiplicationTable {
    public int findKthSmallest(int m, int n, int k) {
        int low = 1;
        int high = m * n;
        int res = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (count(mid, m, n) >= k) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

    /**
     * this method counts how many numbers less than or equal the provided value
     * the matrix have m rows and n cols. value
     */
    int count(int val, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(n, val / i);
        }
        return count;
    }
}
