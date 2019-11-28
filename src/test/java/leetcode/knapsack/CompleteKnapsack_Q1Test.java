package leetcode.knapsack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompleteKnapsack_Q1Test {

    CompleteKnapsack_Q1 test = new CompleteKnapsack_Q1();

    @Test
    void minTips() {
        assertEquals(0, test.minTips(new int[] {15,25,35}, 90));
        assertEquals(0, test.minTips(new int[] {15,25,35}, 80));

        assertEquals(0, test.minTipsOptimized(new int[] {15,25,35}, 90));
        assertEquals(0, test.minTipsOptimized(new int[] {15,25,35}, 80));
    }
}