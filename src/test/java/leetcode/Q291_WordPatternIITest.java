package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q291_WordPatternIITest {

    Q291_WordPatternII test = new Q291_WordPatternII();

    @Test
    void wordPattern() {
        assertTrue(test.wordPattern("abcd", "w1w2w1w2"));
    }

    @Test
    void isValid() {
    }
}