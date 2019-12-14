package leetcode;

/**
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty
 * continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 *
 * Input:
 * nums = [7,2,5,10,8]; m = 2
 * Output:
 * 18
 *
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 */
public class Q410_SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = nums[0];

        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int left = max;
        int right = sum;
        int res = max;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isValid(nums, mid, m)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    boolean isValid(int[] nums, int target, int k) {
        int count = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum > target) {
                sum = num;
                count++;
                if (count > k) {
                    return false;
                }
            }
        }
        return true;
    }
}
