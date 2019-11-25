package leetcode;

public class Q1031_MaximumSumOfTwoNonOverlappingSubarrays {
    public int maxSumTwoNoOverlap(int[] nums, int l, int m) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sums[i + 1] = sum;
        }

        int max = 0;
        for (int i = 0; i + l <= n; i++) {
            int sumL = sums[i + l] - sums[i];
            for (int j = 0; j + m < i; j++) {
                int sumM = sums[j + m] - sums[j];
                max = Math.max(max, sumL + sumM);
            }
            for (int j = i + l; j + m <= n; j++) {
                int sumM = sums[j + m] - sums[j];
                max = Math.max(max, sumL + sumM);
            }
        }
        return max;
    }

    public int maxSumTwo(int[] nums, int l, int m) {
        int n = nums.length;
        int[] sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            sums[i] = sum;
        }

        int lMax = sums[l - 1];
        int mMax = sums[m - 1];
        int res = sums[l + m - 1];
        for (int i = l + m; i < n; i++) {
            lMax = Math.max(lMax, sums[i] - sums[i - m] - sums[i - m - l]);
            mMax = Math.max(mMax, sums[i] - sums[i - l] - sums[i - m - l]);
            res = Math.max(res, Math.max(lMax + sums[i] - sums[i - m], mMax + sums[i] - sums[i - l]));
        }
        return res;
    }
}
