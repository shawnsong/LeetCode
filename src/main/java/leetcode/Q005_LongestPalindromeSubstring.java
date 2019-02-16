package leetcode;

public class Q005_LongestPalindromeSubstring {
	public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            String palindrome = findPalindrome(s, i, i);
            if (palindrome.length() >= res.length()) {
                res = palindrome;
            }
            palindrome = findPalindrome(s, i, i+1);
            if (palindrome.length() >= res.length()) {
                res = palindrome;
            }
        }
        return res;
	}
	
	private String findPalindrome(String s, int left, int right) {
	    String palindrome = "";

	    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
	        palindrome = s.substring(left, right + 1);
	        left--;
	        right++;
        }
        return palindrome;
    }
}
