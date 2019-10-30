package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q857_MinimumCostToHireKWorkersTest {
    Q857_MinimumCostToHireKWorkers test = new Q857_MinimumCostToHireKWorkers();

    @Test
    void testMain() {
        int[] quality = {10, 20, 5};
        int[] wage = {70,50,30};
        int k = 2;
        assertEquals(105.0, test.mincostToHireWorkers(quality, wage, k));
    }
}