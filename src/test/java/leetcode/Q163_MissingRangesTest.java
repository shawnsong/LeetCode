package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Q163_MissingRangesTest {
    Q163_MissingRanges test = new Q163_MissingRanges();

    @Test
    void findMissingRanges() {
        assertEquals(Arrays.asList("0->2147483646"), test.findMissingRanges(new int[]{Integer.MAX_VALUE}, 0, Integer.MAX_VALUE));
    }
}