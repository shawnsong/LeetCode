package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1091Test {
    Q1091 test = new Q1091();

    @Test
    void shortestPathBinaryMatrix() {
        assertEquals(4,
                test.shortestPathBinaryMatrix(new int[][]{
                {0,0,0},
                {1,1,0},
                {1,1,0}})
        );
    }
}