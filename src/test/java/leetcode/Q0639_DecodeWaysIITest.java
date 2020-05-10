package leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q0639_DecodeWaysIITest {
  Q0639_DecodeWaysII test = new Q0639_DecodeWaysII();

  @Test
  void numDecodings() {
    assertEquals(9, test.numDecodings("*"));
    assertEquals(18, test.numDecodings("1*"));
    assertEquals(114, test.numDecodings("10**3"));
  }
}