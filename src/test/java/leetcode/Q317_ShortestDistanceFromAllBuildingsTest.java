package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q317_ShortestDistanceFromAllBuildingsTest {
    Q317_ShortestDistanceFromAllBuildings test = new Q317_ShortestDistanceFromAllBuildings();

    @Test
    void shortestDistance() {
        assertEquals(7, test.shortestDistance(new int[][] {
                {1,0,2,0,1},
                {0,0,0,0,0},
                {0,0,1,0,0}
        }));

        assertEquals(9, test.shortestDistance(new int[][] {
                {0,0,2,0,0,0,2,2,2,0,2,0,2,0,2,0,0,0},
                {2,2,2,2,0,0,0,2,0,0,0,0,1,1,0,0,1,2},
                {0,0,2,0,0,0,0,0,0,2,0,0,0,2,0,0,0,2},
                {0,0,2,0,0,0,0,2,0,2,2,2,0,0,0,0,0,0}
        }));
    }
}