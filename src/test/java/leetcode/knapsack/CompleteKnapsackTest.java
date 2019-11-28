package leetcode.knapsack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompleteKnapsackTest {
    CompleteKnapsack test = new CompleteKnapsack();

    @Test
    void maxValue() {
        int[] w = {2,3,5,7};
        int[] v = {1,5,2,4};
        assertEquals(15, test.maxValue(w, v, 10));
        assertEquals(15, test.maxValueOptimized(w, v, 10));

        w = new int[] {2,3,4,5};
        v = new int[] {30, 50, 100, 200};
        assertEquals(250, test.maxValueOptimized(w, v, 8));
    }
}