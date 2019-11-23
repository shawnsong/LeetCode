package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1235Test {
    Q1235 test = new Q1235();

    @Test
    void jobScheduling() {
         assertEquals(120, test.jobScheduling(
                 new int[]{1,2,3,3},
                 new int[] {3,4,5,6},
                 new int[] {50,10,40,70}));

         assertEquals(150, test.jobScheduling(
                 new int[]{1,2,3,4,6},
                 new int[] {3,5,10,6,9},
                 new int[] {20,20,100,70,60}));

        assertEquals(18, test.jobScheduling(
                new int[]{4,2,4,8,2},
                new int[] {5,5,5,10,8},
                new int[] {1,2,8,10,4}));
    }
}