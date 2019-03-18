package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q323_NumberOfConnectedTest {

    Q323_NumberOfConnected test = new Q323_NumberOfConnected();

    @Test
    void countComponents() {
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {3, 4}
        };
        assertEquals(2, test.countComponents(5, edges));
    }
}