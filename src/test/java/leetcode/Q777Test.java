package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q777Test {
    Q777 test = new Q777();

    @Test
    void canTransform() {
        assertTrue(test.canTransform("XXL", "XLX"));
        assertTrue(test.canTransform("RXXLRXRXL", "XRLXXRRLX"));
        assertFalse(test.canTransform("X", "L"));
    }
}