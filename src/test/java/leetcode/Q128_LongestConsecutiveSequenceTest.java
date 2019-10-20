package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q128_LongestConsecutiveSequenceTest {
    Q128_LongestConsecutiveSequence test = new Q128_LongestConsecutiveSequence();

    @Test
    void longestConsecutive() {
        assertEquals(4, test.longestConsecutive(new int[] {4, 100, 3, 1, 2, 101}));
    }
}