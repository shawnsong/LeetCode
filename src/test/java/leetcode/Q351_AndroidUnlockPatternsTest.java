package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q351_AndroidUnlockPatternsTest {
    Q351_AndroidUnlockPatterns test = new Q351_AndroidUnlockPatterns();

    @Test
    void numberOfPatterns() {
        assertEquals(9, test.numberOfPatterns(1, 1));
    }
}