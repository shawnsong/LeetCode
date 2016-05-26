package leetcode;

import java.util.Arrays;

/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer 
must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Q003_LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
		int max = 1;
		int len = 0;
		int startIdx = 0;
		int[] map = new int[256];
		Arrays.fill(map, -1);
		for (int i = 0; i < s.length(); i++) {
			
			int charIdx = s.charAt(i);
			if (map[charIdx] == -1) {
				len++;
				max = Math.max(max, len);
			} else {
				if (map[charIdx] < startIdx) {
					len++;
					max = Math.max(max, len);
				} else {
					startIdx = map[charIdx] + 1;
					len = i - map[charIdx];
				}
				
			}
			map[charIdx] = i;
		}
		
		return max;
	}
}
