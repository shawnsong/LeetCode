package leetcode;

import java.util.HashMap;

/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in 
pattern and a non-empty word in str.

Examples:

    pattern = "abba", str = "dog cat cat dog" should return true.
    pattern = "abba", str = "dog cat cat fish" should return false.
    pattern = "aaaa", str = "dog cat cat dog" should return false.
    pattern = "abba", str = "dog dog dog dog" should return false.

Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space. 
 */
public class Q290_WordPattern {
	public boolean wordPattern(String pattern, String str) {
		String[] wordArr = str.split(" ");
		if (wordArr.length != pattern.length())
			return false;
		
		String[] map = new String[26];
		
		for (int i = 0; i < pattern.length(); i++) {
			int idx = pattern.charAt(i) - 'a';
			
			if (map[idx] == null) {
				for (int j = 0; j < 26; j++) {
					if (map[j] != null && map[j].equals(wordArr[i]))
						return false;
				}
				map[idx] = wordArr[i];
			} else if (map[idx].equals(wordArr[i]) == false ) {
					return false;
			}
		}
		return true;
	}
}
