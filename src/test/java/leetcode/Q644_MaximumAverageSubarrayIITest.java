package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q644_MaximumAverageSubarrayIITest {
    Q644_MaximumAverageSubarrayII test = new Q644_MaximumAverageSubarrayII();

    @Test
    void findMaxAverage() {
        assertTrue(test.findMaxAverage(new int[] {1,12,-5,-6,50,3}, 4) - 12.75 < 0.000001);
    }
}