package leetcode;


/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */
public class Q004_MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            throw new IllegalArgumentException("wrong input");
        }

        int m = nums1.length;
        int n = nums2.length;

        if (m > n ) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = m;

        while (low <= high) {
            int partition1 = low + (high - low) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;

            int leftMax1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int rightMin1 = partition1 == m ? Integer.MAX_VALUE : nums1[partition1];

            int leftMax2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int rightMin2 = partition2 == m ? Integer.MAX_VALUE : nums2[partition2];

            if (leftMax1 <= rightMin2 && leftMax2 <= rightMin1) {
                // find position of partition
                if (m + n % 2 == 1) {
                    return Math.max(leftMax1, leftMax2);
                } else {
                    return ((double)(Math.max(leftMax1, leftMax2)) + Math.min(rightMin1, rightMin2)) / 2.0;
                }
            } else if (leftMax1 > rightMin2) {
                high = partition1 - 1;
            } else {
                low = partition1 + 1;
            }
        }

        return 0;

    }
}
