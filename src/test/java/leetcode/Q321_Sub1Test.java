package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q321_Sub1Test {

    Q321_Sub1 test = new Q321_Sub1();

    @Test
    void maxArray() {
        String res = test.maxArray(new int[] {9, 1, 2, 5, 8, 3}, 3);
        assertEquals("983", res);
        res = test.maxArray(new int[] {9, 1, 2, 5, 8, 3}, 4);
        assertEquals("9583", res);
    }
}