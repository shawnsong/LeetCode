package leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q1312_MinimumInsertionToMakePalindromeTest {
  Q1312_MinimumInsertionToMakePalindrome test = new Q1312_MinimumInsertionToMakePalindrome();

  @Test
  void minInsertions() {
    assertEquals(1, test.minInsertions("ab"));
    assertEquals(2, test.minInsertions("mbadm"));
    assertEquals(0, test.minInsertions("mbabm"));

    assertEquals(1, test.minInsertions1("ab"));
    assertEquals(2, test.minInsertions1("mbadm"));
    assertEquals(0, test.minInsertions1("mbabm"));
  }
}