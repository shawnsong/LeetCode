package leetcode;

import java.util.Arrays;

public class Q719_FindKthSmallestPairDistance {
    public int smallestDistancePair(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int left = nums[1] - nums[0];
        int right = nums[nums.length - 1] - nums[0];
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (countPairs(nums, mid) >= k) {
                // if we have more than k pairs, it means the diff is too big
                right = mid - 1;
                res = mid;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    int countPairs(int[] nums, int diff) {
        int j = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && nums[j] <= nums[i] + diff) {
                j++;
            }
            count += j - i - 1;
        }
        return count;
    }
}
