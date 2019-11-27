package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Knapsack_Sub1Test {
    Knapsack_Sub1 test = new Knapsack_Sub1();

    @Test
    void maxKnapsack() {
        assertEquals(9, test.maxKnapsack(new int[] {3,4,8,5}, 10));
    }
}