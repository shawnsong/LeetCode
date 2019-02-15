package leetcode;

public class Q005_LongestPalindromeSubstring {
	public String longestPalindrome(String s) {
		if (s == null || s.length() == 0)
			return s;
		String res = "";
		for (int i = 0; i < s.length(); i++) {
			String tmp = findPalindrome(s, i);
			if (tmp.length() > res.length())
				res = tmp;
		}
		return res;
	}
	
	private String findPalindrome(String s, int pos) {
		int i = pos - 1;
		int j = pos + 1;
		String max = s.charAt(pos) + "";
		while (i >= 0 && j < s.length()) {
			if (s.charAt(i) != s.charAt(j))
				break;
			i--;
			j++;
		}
		max = s.substring(i + 1, j);
		
		i = pos;
		j = pos + 1;
		while (i >= 0 && j < s.length()) {
			if (s.charAt(i) != s.charAt(j))
				break;
			i--;
			j++;
		}
		if (j - i - 1 > max.length())
			max = s.substring(i + 1, j);
		return max;
	}
}
