package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q973_KClosestPointsToOriginTest {

    Q973_KClosestPointsToOrigin underTest = new Q973_KClosestPointsToOrigin();

    @Test
    void kClosest() {
        int[][] points = {{1, 3}, {-2, 2}, {2, -2}};
        int[][] res = underTest.kClosest(points, 2);
        for (int[] r : res) {
            System.out.println(r[0]);
        }
    }
}