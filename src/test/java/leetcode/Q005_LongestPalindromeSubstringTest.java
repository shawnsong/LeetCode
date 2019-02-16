package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q005_LongestPalindromeSubstringTest {

    Q005_LongestPalindromeSubstring underTest = new Q005_LongestPalindromeSubstring();

    @Test
    void longestPalindrome() {
        assertEquals(underTest.longestPalindrome("abba"), "abba");
        assertEquals(underTest.longestPalindrome("abc"), "c");
        assertEquals(underTest.longestPalindrome("aa"), "aa");
        assertEquals(underTest.longestPalindrome("a"), "a");
        assertEquals("abcba", underTest.longestPalindrome("abcba"));
        assertEquals("cc", underTest.longestPalindrome("aabbcc") );
        assertEquals(underTest.longestPalindrome("dbaab"), "baab");
    }
}