package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Knapsack_Sub2Test {

    Knapsack_Sub2 test = new Knapsack_Sub2();

    @Test
    void numWays() {
        assertEquals(2, test.numWays(new int[] {1,2,3,3,7}, 7));
        assertEquals(3, test.numWays(new int[] {1,2,3,3,7}, 6));
    }
}