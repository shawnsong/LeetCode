package leetcode;

import java.util.HashMap;

/*
 Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character 
 while preserving the order of characters. No two characters may map to 
 the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.
 */
public class Q205_IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if (s == null && t == null || s.length() == 0 && t.length() == 0)
			return true;
		if (s.length() != t.length())
			return false;
		HashMap<Character, Character> map = new HashMap();
		
		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			
			if (map.containsKey(c1)) {
				if (map.get(c1) != c2)
					return false;
			} else {
				if (map.containsValue(c2))
					return false;
				else
					map.put(c1, c2);
			}
		}
		
		return true;
	}
}
