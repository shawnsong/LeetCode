package leetcode;

/*
 * Write a function to find the longest common prefix string amongst an array of strings. 
 */
public class Q014_LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";

		if (strs.length == 1)
			return strs[0];

		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].length() == 0)
				return "";
			else if (strs[i].length() < minLength)
				minLength = strs[i].length();
		}

		for (int j = 0; j < minLength; j++) {
			for (int i = 1; i < strs.length; i++) {
				if (strs[0].charAt(j) != strs[i].charAt(j))
					return strs[0].substring(0, j);
			}
		}
		return strs[0].substring(0, minLength);
	}
}
