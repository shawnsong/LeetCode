package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class Q128_LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int leftLen = map.getOrDefault(num - 1, 0);
                int rightLen = map.getOrDefault(num + 1, 0);
                int len = leftLen + rightLen + 1;
                max = Math.max(max, len);
                map.put(num - leftLen, len);
                map.put(num + rightLen, len);
                map.put(num, len);
            }
        }
        return max;
    }
}
