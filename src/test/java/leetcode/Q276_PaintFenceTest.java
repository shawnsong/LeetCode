package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q276_PaintFenceTest {

    private Q276_PaintFence test = new Q276_PaintFence();

    @Test
    void numWays() {
        assertEquals(6, test.numWays(3, 2));
    }
}