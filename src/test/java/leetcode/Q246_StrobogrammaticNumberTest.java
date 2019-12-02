package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q246_StrobogrammaticNumberTest {
    Q246_StrobogrammaticNumber test = new Q246_StrobogrammaticNumber();

    @Test
    void isStrobogrammatic() {
        assertTrue(test.isStrobogrammatic("69"));
        assertTrue(test.isStrobogrammatic("619"));
        assertTrue(test.isStrobogrammatic("818"));
        assertTrue(test.isStrobogrammatic("6969"));
        assertFalse(test.isStrobogrammatic("6269"));
    }
}