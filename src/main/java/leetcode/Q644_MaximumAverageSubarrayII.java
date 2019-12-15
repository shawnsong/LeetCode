package leetcode;

public class Q644_MaximumAverageSubarrayII {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        double low = nums[0];
        double high = nums[0];
        double sum = 0;
        for (int num : nums) {
            sum += num;
            low = Math.min(low, num);
            high = Math.max(high, num);
        }
        if (nums.length <= k) {
            return sum / k;
        }
        double epsilon = 0.000001;
        double res = 0;
        while (low + epsilon < high) {
            double mid = low + (high - low) / 2.0;
            if (canFind(nums, mid, k)) {
                res = mid;
                low = mid;
            } else {
                high = mid;
            }
        }
        return res;
    }

    boolean canFind(int[] nums, double target, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i] - target;
        }
        if (sum >= 0) {
            return true;
        }
        double prevSum = 0;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - target;
            prevSum += nums[i - k] - target;
            if (prevSum < 0) {
                sum -= prevSum;
                prevSum = 0;
            }
            if (sum >= 0) {
                return true;
            }
        }
        return false;
    }
}
