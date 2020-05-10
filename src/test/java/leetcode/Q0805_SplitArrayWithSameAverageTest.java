package leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Q0805_SplitArrayWithSameAverageTest {
  Q0805_SplitArrayWithSameAverage test = new Q0805_SplitArrayWithSameAverage();

  @Test
  void splitArraySameAverage() {
    assertTrue(test.splitArraySameAverage(new int[] {3,1,2}));
  }
}