package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q975_OddEvenJumpTest {

    Q975_OddEvenJump test = new Q975_OddEvenJump();
    @Test
    void oddEvenJumps() {
        assertEquals(2, test.oddEvenJumps(new int[] {10,13,12,14,15}));
    }
}