package leetcode;

/**
 * Given an integer array sorted in ascending order, write a function to search target in nums.  If target exists,
 * then return its index, otherwise return -1. However, the array size is unknown to you. You may only access the array
 * using an ArrayReader interface, where ArrayReader.get(k) returns the element of the array at index k (0-indexed).
 *
 * You may assume all integers in the array are less than 10000, and if you access the array out of bounds,
 * ArrayReader.get will return 2147483647.
 */
public class Q702 {
    public int search(ArrayReader reader, int target) {
        int high = 1;
        while (reader.get(high) < target) {
            high = high << 1;
        }

        int left = high >> 1, right = high;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int num = reader.get(mid);
            if (num == target) {
                return mid;
            } else if (num < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
interface ArrayReader {
    int get(int index);
}
