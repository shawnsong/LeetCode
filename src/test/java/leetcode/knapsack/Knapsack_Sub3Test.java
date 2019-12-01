package leetcode.knapsack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Knapsack_Sub3Test {
    Knapsack_Sub3 test = new Knapsack_Sub3();

    @Test
    void maxProbability() {
        assertTrue(0.44 - test.maxProbability(10, new int[]{4,4,5}, new double[]{0.1,0.2,0.3}) < 0.0000001);
    }
}