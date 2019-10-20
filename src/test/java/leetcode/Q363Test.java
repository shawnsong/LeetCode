package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q363Test {
    Q363 test = new Q363();

    @Test
    void maxSumSubmatrix() {
        int[][] m = {{1,0,1},{0,-2,3}};
        assertEquals(2, test.maxSumSubmatrix(m, 2));

        assertEquals(-1, test.maxSumSubmatrix(new int[][] {{2,2,-1}}, 0));
    }
}