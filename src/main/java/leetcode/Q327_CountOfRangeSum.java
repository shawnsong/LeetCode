package leetcode;

public class Q327_CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        return mergeSortCount(sums, 0, sums.length - 1, lower, upper);
    }

    private int mergeSortCount(long[] sums, int startIdx, int endIdx, int lower, int upper) {
        if (startIdx >= endIdx) return 0;
        int mid = startIdx + (endIdx - startIdx) / 2;

        int res = mergeSortCount(sums, startIdx, mid, lower, upper) +
                mergeSortCount(sums, mid + 1, endIdx, lower, upper);

        int left = mid + 1, right = mid + 1;
        for (int i = startIdx; i <= mid; i++) {
            while (left <= endIdx && sums[left] - sums[i] < lower) {
                left++;
            }
            while (right <= endIdx && sums[right] - sums[i] <= upper) {
                right++;
            }
            res += right - left;
        }
        long[] merge = new long[endIdx - startIdx + 1];
        int i = startIdx;
        int j = mid + 1;
        int pos = 0;
        while (i <= mid && j <= endIdx) {
            if (sums[i] < sums[j]) {
                merge[pos] = sums[i];
                pos++;
                i++;
            } else {
                merge[pos] = sums[j];
                pos++;
                j++;
            }
        }
        while (i <= mid) {
            merge[pos++] = sums[i++];
        }
        while (j <= endIdx) {
            merge[pos++] = sums[j++];
        }
        System.arraycopy(merge, 0, sums, startIdx, merge.length);
        return res;
    }
}
