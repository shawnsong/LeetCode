package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q493_ReversePairsTest {

    Q493_ReversePairs test = new Q493_ReversePairs();
    @Test
    void reversePairs() {
        int[] nums = {1,3,2,3,1};
        assertEquals(2, test.reversePairs(nums));

        nums = new int[]{2,4,3,5,1};
        assertEquals(3, test.reversePairs(nums));
    }
}