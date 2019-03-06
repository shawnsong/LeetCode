package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q084_LargestRectangleInHistogramTest {

    Q084_LargestRectangleInHistogram test = new Q084_LargestRectangleInHistogram();

    @Test
    void largestRectangleArea() {
        assertEquals(3, test.largestRectangleArea(new int[] { 2, 1, 2}));
    }
}