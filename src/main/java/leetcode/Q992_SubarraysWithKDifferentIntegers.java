package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of A good
 * if the number of different integers in that subarray is exactly K.
 *
 * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
 *
 * Return the number of good subarrays of A.

 * Example 1:
 * Input: A = [1,2,1,2,3], K = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 *
 * Example 2:
 * Input: A = [1,2,1,3,4], K = 3
 * Output: 3
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 */
public class Q992_SubarraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    int atMostK(int[] A, int K) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            while (map.size() > K ) {
                int num = A[left];
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
                left++;
            }
            // 为什么有 count += i - left + 1?
            // 因为subarray是从left 到i并且最多有K个数字, 那么连续的subarray就是
            // (left...i), (left+1...i), (left+2...i) .... (i-1...i), (i...i) 一共是i - left + 1个数组
            count += i - left + 1;
        }
        return count;
    }

}
