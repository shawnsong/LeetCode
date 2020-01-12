package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q862_ShortestSubArrayWithSumKTest {

    Q862_ShortestSubArrayWithSumK test = new Q862_ShortestSubArrayWithSumK();

    @Test
    void shortestSubarray() {
        assertEquals(2, test.shortestSubarray(new int[]{56,-21,56,35,-9}, 61));

        assertEquals(2, test.shortestSubArrayMonotonicQueue(new int[]{56,-21,56,35,-9}, 61));
    }
}