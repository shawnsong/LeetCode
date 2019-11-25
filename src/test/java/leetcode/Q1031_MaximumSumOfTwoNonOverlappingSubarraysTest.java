package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1031_MaximumSumOfTwoNonOverlappingSubarraysTest {

    Q1031_MaximumSumOfTwoNonOverlappingSubarrays test = new Q1031_MaximumSumOfTwoNonOverlappingSubarrays();

    @Test
    void maxSumTwoNoOverlap() {
        assertEquals(20, test.maxSumTwoNoOverlap(new int[] {0,6,5,2,2,5,1,9,4}, 1, 2));
        assertEquals(29, test.maxSumTwoNoOverlap(new int[] {3,8,1,3,2,1,8,9,0}, 3, 2));
    }
}