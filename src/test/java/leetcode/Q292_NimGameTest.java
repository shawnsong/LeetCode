package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q292_NimGameTest {

    Q292_NimGame test = new Q292_NimGame();

    @Test
    void canWinNim() {
        assertTrue(test.canWinNim(43));
    }
}