package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1007_MinimumDominoRotationsForEqualRowTest {

    Q1007_MinimumDominoRotationsForEqualRow test = new Q1007_MinimumDominoRotationsForEqualRow();

    @Test
    void minDominoRotations() {
        assertEquals(1,
                test.minDominoRotations(new int[]{1,2,1,1,1,2,2,2}, new int[]{2,1,2,2,2,2,2,2}));
    }
}