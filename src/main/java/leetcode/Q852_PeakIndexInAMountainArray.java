package leetcode;

public class Q852_PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (true) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] > nums[mid - 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
}
