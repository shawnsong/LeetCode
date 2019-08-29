package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q248_StrobogrammaticNumberIIITest {
    Q248_StrobogrammaticNumberIII test = new Q248_StrobogrammaticNumberIII();

    @Test
    void strobogrammaticInRange() {
        assertEquals(3, test.strobogrammaticInRange("0", "9"));
        assertEquals(3, test.strobogrammaticInRange("50", "100"));
    }
}