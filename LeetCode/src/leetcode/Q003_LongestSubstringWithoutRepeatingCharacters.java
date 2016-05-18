package leetcode;

import java.util.HashMap;

/*
 Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer 
 must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Q003_LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] arg) {
		lengthOfLongestSubstring("tmmzuxt");
	}
	
	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		
		int res = 0;
		HashMap<Character, Integer> map = new HashMap();
//		int[] map = new int[26];
		int startIdx = 0;
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(s.charAt(i))) {
				
				if (i + 1 - startIdx > res)
					res = i + 1 - startIdx;
//				res = s.substring(startIdx, i + 1);
			} else {
				if (map.get(s.charAt(i)) < startIdx) {
					if (i + 1 - startIdx > res)
						res = i + 1 - startIdx;
				} else {
					startIdx = map.get(s.charAt(i)) + 1;
				}
			}
			map.put(s.charAt(i), i);
		}
		System.out.println(res);
		return res;
	}
}
