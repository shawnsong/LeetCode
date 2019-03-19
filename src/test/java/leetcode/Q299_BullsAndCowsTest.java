package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q299_BullsAndCowsTest {

    Q299_BullsAndCows test = new Q299_BullsAndCows();

    @Test
    void getHint() {
        assertEquals("1A3B", test.getHint("1803", "3810"));
    }
}