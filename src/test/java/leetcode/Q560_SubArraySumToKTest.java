package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q560_SubArraySumToKTest {
    Q560_SubArraySumToK test = new Q560_SubArraySumToK();

    @Test
    void subarraySum() {
        assertEquals(2, test.subarraySum(new int[] {1,1,1}, 2));
    }
}