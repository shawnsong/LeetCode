package leetcode;

public class Q1095_FindInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIdx = findPeakIdx(mountainArr);
        int res = search(0, peakIdx, target, mountainArr, false);
        if (res != -1) {
            return res;
        }
        return search(peakIdx + 1, mountainArr.length() - 1, target, mountainArr, true);
    }

    int search(int left, int right, int target, MountainArray arr, boolean desc) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midVal = arr.get(mid);
            if (midVal == target) {
                return mid;
            } else if (midVal < target) {
                if (!desc) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (!desc) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    int findPeakIdx(MountainArray mountainArray) {
        int left = 0;
        int right = mountainArray.length() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mountainArray.get(mid) < mountainArray.get(mid + 1)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    interface MountainArray {
        int get(int idx);
        int length();
    }
}
