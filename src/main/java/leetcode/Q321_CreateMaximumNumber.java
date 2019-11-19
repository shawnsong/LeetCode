package leetcode;

import java.util.Stack;

public class Q321_CreateMaximumNumber {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        int[] res = new int[k];
        // Math.max(0, k - n) is for the case where k > n
        // k = 4, n = 2, so i (for num1) needs to be at least of length 2
        // i <= m is when n + m == k
        for (int i = Math.max(0, k - n); i <= k && i <= m; i++) {
            int[] sub1 = maxArray(nums1, i);
            int[] sub2 = maxArray(nums2, k - i);
            int[] candidate = merge(sub1, sub2, k);
            if (greater(candidate, 0, res, 0)) {
                res = candidate;
            }
        }
        return res;
    }

    int[] merge(int[] nums1, int[] nums2, int k) {
        int[] res = new int[k];
        int i = 0;
        int j = 0;
        int pos = 0;
        while (pos < k) {
            if (greater(nums1, i, nums2, j)) {
                res[pos] = nums1[i];
                i++;
            } else {
                res[pos] = nums2[j];
                j++;
            }
            pos++;
        }
        return res;
    }

    boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    int[] maxArray(int[] nums, int len) {
        if (len >= nums.length) {
            return nums;
        }

        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (n - i + stack.size() > len && !stack.isEmpty() && nums[i] > stack.peek()) {
                stack.pop();
            }
            if (stack.size() < len) {
                stack.push(nums[i]);
            }
        }
        int[] res = new int[len];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i++;
        }
        reverse(res);
        return res;
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
