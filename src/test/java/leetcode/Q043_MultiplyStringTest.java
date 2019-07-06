package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q043_MultiplyStringTest {

    Q043_MultiplyString test = new Q043_MultiplyString();
    @Test
    void multiply() {
        assertEquals("5535", test.multiply("123", "45"));
    }
}