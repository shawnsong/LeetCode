package leetcode;

/**
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
 *
 * You need to return the number of important reverse pairs in the given array.
 *
 * Example1:
 *
 * Input: [1,3,2,3,1]
 * Output: 2
 * Example2:
 *
 * Input: [2,4,3,5,1]
 * Output: 3
 */
public class Q493_ReversePairs {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        return reverse(nums, 0, nums.length - 1);
    }

    int reverse(int[] nums, int startIdx, int endIdx) {
        if (startIdx >= endIdx) return 0;

        int mid = startIdx + (endIdx - startIdx) / 2;
        int res = reverse(nums, startIdx, mid) + reverse(nums, mid + 1, endIdx);

        int left = startIdx, right = mid + 1;
        while (left <= mid) {
            while (right <= endIdx && nums[left] > 2L * nums[right]) right++;
            res += right - (mid + 1);
            left++;
        }
        left = startIdx;
        right = mid + 1;
        int[] merge = new int[endIdx - startIdx + 1];
        int i = 0;
        while (left <= mid && right <= endIdx) {
            if (nums[left] < nums[right]) {
                merge[i++] = nums[left++];
            } else {
                merge[i++] = nums[right++];
            }
        }
        while (left <= mid ) {
            merge[i++] = nums[left++];
        }
        while (right <= endIdx) {
            merge[i++] = nums[right++];
        }
        System.arraycopy(merge, 0, nums, startIdx, merge.length);
        return res;
    }
}
