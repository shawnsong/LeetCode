package leetcode.knapsack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiKnapsackTest {

    MultiKnapsack test = new MultiKnapsack();

    @Test
    void maxWeights() {
        assertEquals(64, test.maxWeights(new int[] {3, 2}, new int[] {30, 16}, new int[] {1, 6}, 8));
        assertEquals(64, test.maxWeightsOptimized(new int[] {3, 2}, new int[] {30, 16}, new int[] {1, 6}, 8));
    }
}