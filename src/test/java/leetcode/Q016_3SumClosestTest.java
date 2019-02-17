package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q016_3SumClosestTest {

    Q016_3SumClosest underTest = new Q016_3SumClosest();

    @Test
    void threeSumClosest() {
        int[] nums = {1,1,1,1};
        int res = underTest.threeSumClosest(nums, 1);
        assertEquals(3, res);


        assertEquals(2, underTest.threeSumClosest(new int[] {-1,2,1,-4}, 1));
    }
}