package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q719_FindKthSmallestPairDistanceTest {
    Q719_FindKthSmallestPairDistance test = new Q719_FindKthSmallestPairDistance();

    @Test
    void smallestDistancePair() {
        assertEquals(0, test.smallestDistancePair(new int[]{1,1,3}, 1));
        assertEquals(2, test.smallestDistancePair(new int[]{1,1,3}, 2));
    }
}