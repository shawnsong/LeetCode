package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q020_ValidParenthesesTest {

    Q020_ValidParentheses test = new Q020_ValidParentheses();

    @Test
    void isValid() {
        assertTrue(test.isValid("(([]{[]}))"));
        assertFalse(test.isValid("(]"));
        assertFalse(test.isValid("([)]"));
    }
}