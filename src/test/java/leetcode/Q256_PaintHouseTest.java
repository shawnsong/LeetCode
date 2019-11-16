package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q256_PaintHouseTest {
    Q256_PaintHouse test = new Q256_PaintHouse();

    @Test
    void minCost() {
        assertEquals(10, test.minCost(new int[][] {{17,2,17},{16,16,5},{14,3,19}}));
    }
}