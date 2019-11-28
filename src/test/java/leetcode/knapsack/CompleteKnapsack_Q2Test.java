package leetcode.knapsack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompleteKnapsack_Q2Test {
    CompleteKnapsack_Q2 test = new CompleteKnapsack_Q2();

    @Test
    void numWays() {
        assertEquals(2, test.numWays(new int[]{2,3,6,7}, 7));
        assertEquals(2, test.numWays2(new int[]{2,3,6,7}, 7));

        assertEquals(3, test.numWays(new int[]{2,3,4,5}, 7));
        assertEquals(3, test.numWays2(new int[]{2,3,4,5}, 7));
    }
}