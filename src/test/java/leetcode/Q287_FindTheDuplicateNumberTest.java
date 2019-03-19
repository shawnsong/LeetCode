package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q287_FindTheDuplicateNumberTest {

    Q287_FindTheDuplicateNumber test = new Q287_FindTheDuplicateNumber();

    @Test
    void test() {
        int[] nums = {1, 2, 3, 4, 2};
        assertEquals(2, test.findDuplicate(nums));
    }
}