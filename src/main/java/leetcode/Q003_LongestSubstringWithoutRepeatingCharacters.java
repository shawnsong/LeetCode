package leetcode;

import java.util.Arrays;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 *
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 *
 * Given "bbbbb", the answer is "b", with the length of 1.
 *
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer
 * must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Q003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int[] count = new int[256];
        Arrays.fill(count, -1);

        int left = 0, right = 0;
        while (right < s.length()) {
            if(count[s.charAt(right)] == -1) {
                count[s.charAt(right)] = right;
                max = Math.max(max, right - left + 1);
                right++;
                continue;
            } else {
                count[s.charAt(left)] = -1;
                left++;
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null) {
            return 0;
        }

        int start = 0;
        int[] index = new int[256];
        Arrays.fill(index, -1);
        int maxLen = 0;
        int currentLen = 0;
        for (int i = 0; i < s.length(); i++) {
            int offset = s.charAt(i);
            if (index[offset] == -1 || index[offset] < start) {
                currentLen++;
            } else {
                currentLen = i - index[offset];
                start = index[offset] + 1;
            }
            maxLen = Math.max(maxLen, currentLen);
            index[offset] = i;
        }
        return maxLen;
    }

}
