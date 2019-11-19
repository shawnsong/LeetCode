package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q321_Sub2Test {
    Q321_Sub2 test = new Q321_Sub2();

    @Test
    void maxArray() {
        int[] num1 = {2, 8, 5, 3};
        int[] num2 = {3, 8, 9, 1};
        assertEquals("38928531", test.maxArray(num1, num2));
    }

    @Test
    void greater() {
        assertTrue(test.greater(new int[] {1,1,2}, 0, new int[] {1, 1, 1}, 0));
        assertFalse(test.greater(new int[] {2, 8,5,9}, 0, new int[] {3, 8, 5, 1}, 0));
        assertTrue(test.greater(new int[] {2, 8,5,9}, 1, new int[] {3, 8, 5, 1}, 1));
    }
}