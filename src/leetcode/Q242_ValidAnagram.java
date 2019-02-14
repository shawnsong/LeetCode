package leetcode;

/*
 Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class Q242_ValidAnagram {

	public boolean isAnagram(String s, String t) {
		if (s == null && t == null)
			return true;
		if (s.length() != t.length() || s == null || t == null)
			return false;

		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			
			count[c1 - 'a']++;
			count[c2 - 'a']--;
		}
		
		for (int i = 0; i < count.length; i++)
			if (count[i] != 0)
				return false;
		
		return true;
	}
}
