package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q788Test {
    Q788 test = new Q788();

    @Test
    void rotatedDigits() {
        assertEquals(4, test.rotatedDigits(10));
    }

    @Test
    void isValid() {
        assertTrue(test.isValid(25));
        assertTrue(test.isValid(26));
        assertFalse(test.isValid(32));
        assertFalse(test.isValid(72));
        assertFalse(test.isValid(42));
    }
}