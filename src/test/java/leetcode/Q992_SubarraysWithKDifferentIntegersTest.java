package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q992_SubarraysWithKDifferentIntegersTest {

    Q992_SubarraysWithKDifferentIntegers test = new Q992_SubarraysWithKDifferentIntegers();

    @Test
    void atMostK() {
        assertEquals(7, test.subarraysWithKDistinct(new int[] {1,2,1,2,3}, 2));
    }
}