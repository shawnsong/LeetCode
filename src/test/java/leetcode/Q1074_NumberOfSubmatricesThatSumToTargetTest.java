package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1074_NumberOfSubmatricesThatSumToTargetTest {
    Q1074_NumberOfSubmatricesThatSumToTarget test = new Q1074_NumberOfSubmatricesThatSumToTarget();

    @Test
    void numSubMatrixSumTarget() {
        int[][] matrix =  {{0,1,0},{1,1,1},{0,1,0}};
        assertEquals(4, test.numSubMatrixSumTarget(matrix, 0));

        matrix = new int[][] {{1, -1}, {-1, 1}};
        assertEquals(5, test.numSubMatrixSumTarget(matrix, 0));
    }
}