package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q392_IsSubsequenceTest {

    Q392_IsSubsequence test = new Q392_IsSubsequence();

    @Test
    void isSubsequence() {
        assertTrue(test.isSubsequence("abc", "ahbgdc"));
        assertFalse(test.isSubsequence("axc", "ahbgdc"));
        assertFalse(test.isSubsequence("acb", "ahbgdc"));
    }
}