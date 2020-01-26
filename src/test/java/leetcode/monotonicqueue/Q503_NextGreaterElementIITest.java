package leetcode.monotonicqueue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q503_NextGreaterElementIITest {
    Q503_NextGreaterElementII test = new Q503_NextGreaterElementII();

    @Test
    void nextGreaterElements() {
        assertArrayEquals(new int[] {2, -1, 2}, test.nextGreaterElements(new int[] {1,2,1}));
    }
}