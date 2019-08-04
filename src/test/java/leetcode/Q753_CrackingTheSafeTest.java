package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class Q753_CrackingTheSafeTest {

    Q753_CrackingTheSafe test = new Q753_CrackingTheSafe();

    @Test
    void crackSafe() {
        String res = test.crackSafe(1, 1);
        assertEquals("0", res);

        assertTrue(new HashSet<>(Arrays.asList("01", "10")).contains(test.crackSafe(1, 2)));

        assertTrue(new HashSet<>(Arrays.asList("00110", "01100", "10011", "11001")).contains(test.crackSafe(2, 2)));
    }
}