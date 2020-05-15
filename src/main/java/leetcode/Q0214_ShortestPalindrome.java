package leetcode;

/**
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 * Example 1:
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 */
public class Q0214_ShortestPalindrome {
  public String shortestPalindrome(String s) {
    int j = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == s.charAt(j)) {
        j++;
      }
    }
    if (j == s.length()) {
      return s;
    }
    String lastPart = s.substring(j);
    String firstPart = new StringBuilder(lastPart).reverse().toString();
    String mid = s.substring(0, j);

    String midPart = shortestPalindrome(mid);
    return  firstPart + midPart + lastPart;
  }
}
