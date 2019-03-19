package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q294_FlipGameIITest {

    Q294_FlipGameII test = new Q294_FlipGameII();

    @Test
    void canWin() {
        assertTrue(test.canWin("++++++"));
    }
}