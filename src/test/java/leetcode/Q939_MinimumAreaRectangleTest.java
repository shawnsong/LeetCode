package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q939_MinimumAreaRectangleTest {
    Q939_MinimumAreaRectangle test = new Q939_MinimumAreaRectangle();

    @Test
    void minAreaRect() {
        assertEquals(4, test.minAreaRect(new int[][] {{1,1},{1,3},{3,1},{3,3},{2,2}}));
    }
}