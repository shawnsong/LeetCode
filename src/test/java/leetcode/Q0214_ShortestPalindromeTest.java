package leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q0214_ShortestPalindromeTest {

  Q0214_ShortestPalindrome test = new Q0214_ShortestPalindrome();

  @Test
  void shortestPalindrome() {
    assertEquals("acbabca", test.shortestPalindrome("abca"));
  }
}