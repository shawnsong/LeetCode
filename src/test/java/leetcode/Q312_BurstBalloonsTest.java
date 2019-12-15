package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q312_BurstBalloonsTest {
    Q312_BurstBalloons test = new Q312_BurstBalloons();

    @Test
    void maxCoins() {
        assertEquals(167, test.maxCoins(new int[] {3,1,5,8}));
    }
}