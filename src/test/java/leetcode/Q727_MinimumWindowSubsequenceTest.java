package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q727_MinimumWindowSubsequenceTest {
    Q727_MinimumWindowSubsequence test = new Q727_MinimumWindowSubsequence();

    @Test
    void minWindow() {
        assertEquals("bdde", test.minWindow("abdde", "bde"));
    }
}