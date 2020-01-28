package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q338_CountingBitsTest {
    Q338_CountingBits test = new Q338_CountingBits();

    @Test
    void countBits() {
        assertArrayEquals(new int[] {0,1,1}, test.countBits(2));
    }
}