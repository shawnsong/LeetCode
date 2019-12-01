package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1074_Sub1Test {

    Q1074_Sub1 test = new Q1074_Sub1();

    @Test
    void numOfSubArray() {
        assertEquals(3, test.numOfSubArray(new int[] {0, 0}, 0));
    }
}