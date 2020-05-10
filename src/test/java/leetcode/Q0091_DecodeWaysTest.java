package leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q0091_DecodeWaysTest {

  Q0091_DecodeWays test = new Q0091_DecodeWays();

  @Test
  void numDecodings() {
    assertEquals(1, test.numDecodings("10"));
    assertEquals(0, test.numDecodings("100"));
  }
}