package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1066_CampusBikesIITest {

    Q1066_CampusBikesII test = new Q1066_CampusBikesII();

    @Test
    void assignBikes() {
        int[][] workers = {{0, 0}, {2, 1}};
        int[][] bikes = {{1, 2}, {3, 3}};

        assertEquals(6, test.assignBikes(workers, bikes));

        workers = new int[][]{{0, 0}, {1, 1}, {2, 0}};
        bikes = new int[][]{{1, 0}, {2, 2}, {2, 1}};
        assertEquals(4, test.assignBikes(workers, bikes));
    }
}