package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q261_GraphValidTreeTest {

    Q261_GraphValidTree test = new Q261_GraphValidTree();

    @Test
    void validTree() {
        int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};
        assertTrue(test.validTree(5, edges));

        edges = new int[][] {{0,1}, {1,2}, {3,4}};
        assertFalse(test.validTree(5, edges));

        edges = new int[][] {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
        assertFalse(test.validTree(5, edges));
    }
}