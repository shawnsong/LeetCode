package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q410_SplitArrayLargestSumTest {
    Q410_SplitArrayLargestSum test = new Q410_SplitArrayLargestSum();

    @Test
    void splitArray() {
        assertEquals(18, test.splitArray(new int[] {7,2,5,10,8}, 2));
        assertEquals(Integer.MAX_VALUE, test.splitArray(new int[] {0, Integer.MAX_VALUE}, 2));
    }
}