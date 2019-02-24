package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q076_MinimumWindowSubstringTest {

    Q076_MinimumWindowSubstring underTest = new Q076_MinimumWindowSubstring();
    @Test
    void minWindow() {
        System.out.println(underTest.minWindow("ADOBECODEBANC", "ABC"));
    }
}