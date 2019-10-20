package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q685_RedundantConnectionIITest {

    Q685_RedundantConnectionII test = new  Q685_RedundantConnectionII();
    @Test
    void findRedundantDirectedConnection() {
        int[][] edges = {{1, 2}, {2, 3}, {3, 1}};
        int[] edge = test.findRedundantDirectedConnection(edges);
        System.out.println(edge[0] + "-" + edge[1]);
    }
}