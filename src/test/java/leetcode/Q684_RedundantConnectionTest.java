package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q684_RedundantConnectionTest {

    Q684_RedundantConnection test = new Q684_RedundantConnection();

    @Test
    void findRedundantConnection() {
        int[][] edges = {
                {1, 2}, {1, 3}, {2, 3}
        };
        int[] res = test.findRedundantConnection(edges);
        assertEquals(2, res[0]);
        assertEquals(3, res[1]);
    }
}