package leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q0149MaxPointsOnALineTest {
  Q0149_MaxPointsOnALine test = new Q0149_MaxPointsOnALine();

  @Test
  public void test() {
    assertEquals(3, test.maxPoints(new int[][] {{1, 1}, {2, 2}, {3, 3}}));
  }

}