package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1269_NumberOfWaysToStayAtSamePlaceTest {
    Q1269_NumberOfWaysToStayAtSamePlace test = new Q1269_NumberOfWaysToStayAtSamePlace();

    @Test
    void numWays() {
        assertEquals(8, test.numWays(4, 2));

        assertEquals(9, test.numWays(4, 3));
    }
}