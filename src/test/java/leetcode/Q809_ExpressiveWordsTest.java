package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q809_ExpressiveWordsTest {

    Q809_ExpressiveWords test = new Q809_ExpressiveWords();

    @Test
    void isValid() {
        assertTrue(test.isValid("helllo", "hello"));
        assertFalse(test.isValid("hello", "helo"));
        assertTrue(test.isValid("heeellooo", "hello"));
        assertFalse(test.isValid("heeello", "he"));

        assertFalse(test.isValid("heeellooo", "axxxrrzzz"));
    }
}