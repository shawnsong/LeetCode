package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Q802_FindEventualSafeStatesTest {
    Q802_FindEventualSafeStates test = new Q802_FindEventualSafeStates();

    @Test
    void eventualSafeNodes() {
        assertEquals(Arrays.asList(2, 4, 5, 6), test.eventualSafeNodes(new int[][] {
                {1,2}, {2, 3}, {5}, {0}, {5}, {}, {}
        }));
        assertEquals(Arrays.asList(0, 1, 2, 3, 4), test.eventualSafeNodes(new int[][] {
                {}, {0, 2, 3, 4}, {3}, {4}, {}
        }));
    }
}