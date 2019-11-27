package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnapsackTest {
    Knapsack test = new Knapsack();

    @Test
    void maxValue() {
        System.out.println(test.maxValue(new int[] {2,3,5,7}, new int[] {1,5,2,4}, 10));
    }
}