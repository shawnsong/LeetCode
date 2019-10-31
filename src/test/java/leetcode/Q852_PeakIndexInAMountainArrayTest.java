package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q852_PeakIndexInAMountainArrayTest {
    Q852_PeakIndexInAMountainArray test = new Q852_PeakIndexInAMountainArray();

    @Test
    void peakIndexInMountainArray() {
        assertEquals(1, test.peakIndexInMountainArray(new int[] {0, 1, 0}));
        assertEquals(2, test.peakIndexInMountainArray(new int[] {0, 1, 2, 0}));
    }
}