package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class Q139_WordBreakTest {

    Q139_WordBreak underTest = new Q139_WordBreak();

    @Test
    void wordBreak() {
        assertTrue(underTest.wordBreak("leetcode", new HashSet<>(Arrays.asList("leet", "code"))));
        assertTrue(underTest.wordBreak("applepenapple", new HashSet<>(Arrays.asList("apple", "pen"))));
    }
}