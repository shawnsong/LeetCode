package leetcode;

import java.util.Arrays;

public class Q327_CountRangeSum {

    public int countRangeSum(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        long[] sum = new long[nums.length+1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        // int count = countWhileMergeSort(sum, 0, nums.length + 1, lower, upper);
        Arrays.sort(sum);
        int count = 0;
        int j = 0, k = 0;
        for (int i = 0; i < sum.length; i++) {
            while (k < sum.length && sum[k] - sum[i] < lower) k++;
            while (j < sum.length && sum[j] - sum[i] <= upper) j++;
            count += j - k;
//            k++;
//            j++;
        }

        return count;
    }
}
