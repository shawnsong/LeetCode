package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q792_NumberOfMatchingSubsequencesTest {

    Q792_NumberOfMatchingSubsequences test = new Q792_NumberOfMatchingSubsequences();

    @Test
    void numMatchingSubseq() {
        assertEquals(1, test.numMatchingSubseq("abcde", new String[] {"a"}));
        assertEquals(1, test.numMatchingSubseq("abcde", new String[] {"acd"}));
        assertEquals(1, test.numMatchingSubseq("abcde", new String[] {"ace"}));
        assertEquals(0, test.numMatchingSubseq("abcde", new String[] {"bb"}));
        assertEquals(3, test.numMatchingSubseq("abcde", new String[] {"a", "acd", "ace"}));
    }
}