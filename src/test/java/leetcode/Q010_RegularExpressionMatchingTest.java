package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q010_RegularExpressionMatchingTest {

    Q010_RegularExpressionMatching underTest = new Q010_RegularExpressionMatching();

    @Test
    void isMatch() {

        assertTrue(underTest.isMatch("bc", "ba*c"));    // empty
        assertTrue(underTest.isMatch("bac", "ba*c"));   // 1
        assertTrue(underTest.isMatch("aaac", "a*c"));   // multiple

        
        assertTrue(underTest.isMatch("bc", "b.*c"));
        assertTrue(underTest.isMatch("bc", "b.*c"));
        assertTrue(underTest.isMatch("bac", "b.c"));
        assertTrue(underTest.isMatch("baaac", "b.*c"));
        assertTrue(underTest.isMatch("baabc", "b.*c"));

        assertFalse(underTest.isMatch("bbc", "bc"));
        assertFalse(underTest.isMatch("baabc", "ba*c"));
    }
}