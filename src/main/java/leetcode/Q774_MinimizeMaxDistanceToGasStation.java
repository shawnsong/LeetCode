package leetcode;

/**
 * On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], where N = stations.length.
 * Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.
 * Return the smallest possible value of D.
 *
 * Example:
 * Input: stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
 * Output: 0.50000
 * Note:
 * stations.length will be an integer in range [10, 2000].
 * stations[i] will be an integer in range [0, 10^8]
 * K will be an integer in range [1, 10^6].
 * Answers within 10^-6 of the true value will be accepted as correct.
 */
public class Q774_MinimizeMaxDistanceToGasStation {
    public double minMaxGasDist(int[] stations, int k) {
        if (stations == null || stations.length < 2) {
            return 0;
        }
        int n = stations.length;
        double left = 0;
        double right = stations[n - 1] - stations[0];
        double epsilon = 0.000001;
        double res = 0;
        while (left + epsilon < right) {
            double mid = left + (right - left) / 2;
            if (isValid(stations, mid, k)) {
                right = mid;
                res = mid;
            } else {
                left = mid;
            }
        }
        return res;
    }

    boolean isValid(int[] nums, double dist, int k) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            count += Math.ceil(nums[i+1] - nums[i]) / dist - 1;
            if (count > k) {
                return false;
            }
        }
        return true;
    }
}
