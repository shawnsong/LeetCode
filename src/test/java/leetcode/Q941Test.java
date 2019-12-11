package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q941Test {
    Q941 test = new Q941();

    @Test
    void validMountainArray() {
        assertTrue(test.validMountainArray(new int[] {1,2,1}));
        assertFalse(test.validMountainArray(new int[] {1,2, 2}));
        assertFalse(test.validMountainArray(new int[] {1,2, 3}));
        assertFalse(test.validMountainArray(new int[] {3, 2, 1}));
    }
}