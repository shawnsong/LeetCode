package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1234Test {

    @Test
    void balancedString() {
        Q1234 test = new Q1234();
        assertEquals(4, test.balancedString("WWEQERQWQWWRWWERQWEQ"));
        assertEquals(3, test.balancedString("QQQQ"));
        assertEquals(2, test.balancedString("QQQE"));
        assertEquals(1, test.balancedString("QQEW"));
    }

}