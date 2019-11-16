package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q265_PaintHousesIITest {
    private Q265_PaintHousesII test = new Q265_PaintHousesII();

    @Test
    void test() {
        assertEquals(5, test.minCostII(new int[][]{{1,5,3}, {2,9,4}}));
        assertEquals(8, test.minCostII(new int[][]{{8}}));
    }
}