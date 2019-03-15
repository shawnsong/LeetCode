package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q286_WallsAndGatesTest {

    Q286_WallsAndGates test = new Q286_WallsAndGates();

    @Test
    void wallsAndGates() {
        int INF = Integer.MAX_VALUE;
        int[][] rooms = {
                {INF, -1,   0,  INF},
                {INF, INF, INF, -1},
                {INF, -1,  INF, -1},
                {0,   -1,  INF, INF}
        };

        test.wallsAndGates(rooms);
        System.out.println(rooms);
    }
}