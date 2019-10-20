package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1168_WaterDistributionInVillageTest {
    Q1168_WaterDistributionInVillage test = new Q1168_WaterDistributionInVillage();

    @Test
    void minCostToSupplyWater() {
        int[] wells = {1, 2, 4};
        int[][] pipes = {{1,2,1}, {2,3,2}};
        assertEquals(4, test.minCostToSupplyWater(3, wells, pipes));

        int n = 5;
//        wells = new int[]{46012,72474,64965,751,33304};
//        pipes = new int[][] {{2,1,6719} ,{3,2,75312},{5,3,44918}};
        wells = new int[] {46, 72, 64, 7, 33};
        pipes = new int[][] {{2, 1, 6}, {3, 2, 75}, {5, 3, 44}};
        assertEquals(136, test.minCostToSupplyWater(n, wells, pipes));
    }
}