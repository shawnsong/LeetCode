package leetcode;

/**
 * divide the array to k + 1 parts, each part is a continuous sub-array of the array. find the largest possible sum
 * of the smallest sub-arrays, i.e. we want the smallest sub-array to be as large as possible.
 *
 * Similar to Q1101 & Q401
 */
public class Q1231_DivideChocolate {
    public int maximizeSweetness(int[] sweetness, int k) {
        int left = 1, right = 1000000000 / (k + 1);
        int res = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (valid(sweetness, mid, k + 1)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return  res;
    }

    boolean valid(int[] nums, int target, int k) {
        int count = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                sum = 0;
                count++;
                if (count > k) {
                    return false;
                }
            }
        }
        return true;
    }
}
