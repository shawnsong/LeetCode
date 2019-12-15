package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1293_ShortestPathInAGridWithObstaclesEliminationTest {
    Q1293_ShortestPathInAGridWithObstaclesElimination test = new Q1293_ShortestPathInAGridWithObstaclesElimination();
    @Test
    void shortestPath() {
        System.out.println(test.shortestPath(new int[][] {{0,1,0,1}, {1,0,0,0}}, 8));
        System.out.println(test.shortestPath(new int[][] {
                {0,0,1,0,0,0,0,1,0,1,1,0,0,1,1},
                {0,0,0,1,1,0,0,1,1,0,1,0,0,0,1},
                {1,1,0,0,0,0,0,1,0,1,0,0,1,0,0},
                {1,0,1,1,1,1,0,0,1,1,0,1,0,0,1},
                {1,0,0,0,1,1,0,1,1,0,0,1,1,1,1},
                {0,0,0,1,1,1,0,1,1,0,0,1,1,1,1},
                {0,0,0,1,0,1,0,0,0,0,1,1,0,1,1},
                {1,0,0,1,1,1,1,1,1,0,0,0,1,1,0},
                {0,0,1,0,0,1,1,1,1,1,0,1,0,0,0},
                {0,0,0,1,1,0,0,1,1,1,1,1,1,0,0},
                {0,0,0,0,1,1,1,0,0,1,1,1,0,1,0}}, 27));

    }
}