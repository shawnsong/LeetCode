package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Q305_NumberOfIslandsIITest {

    Q305_NumberOfIslandsII test = new Q305_NumberOfIslandsII();

    @Test
    void numIslands2() {
        assertEquals(Arrays.asList(1, 1, 2, 3), test.numIslands2(3, 3, new int[][] {{0,0}, {0,1}, {1,2}, {2,1}}));
        assertEquals(Arrays.asList(1, 1, 2, 2), test.numIslands2(3, 3, new int[][] {{0,0}, {0,1}, {1,2}, {1,2}}));
    }
}
