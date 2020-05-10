package leetcode;

import java.util.Arrays;

public class Q0805_SplitArrayWithSameAverage {
  public boolean splitArraySameAverage(int[] nums) {
  int sum = 0;
  for (int num : nums) sum += num;

  int n = nums.length, m = n / 2;
  Arrays.sort(nums);
  for (int i = 1; i <= m; i++) {
    if (sum * i % n == 0 && canPartition(nums, sum * i / n, 0, i)) {
      return true;
    }
  }
  return false;
}

    boolean canPartition(int[] nums, int target, int startIdx, int k) {
      if (target > k * nums[startIdx]) {
        return false;
      }
      if (k == 0) {
        return target == 0;
      }
      for (int i = startIdx; i <= nums.length - k; i++) {
        if (nums[i] <= target && canPartition(nums, target - nums[i], i + 1, k - 1)) {
          return true;
        }
      }
      return false;
    }
}
