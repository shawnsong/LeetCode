package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q004_MedianOfTwoSortedArraysTest {

    Q004_MedianOfTwoSortedArrays test = new Q004_MedianOfTwoSortedArrays();

    @Test
    void findMedianSortedArrays() {
        int[] num1 = {1, 2};
        int[] num2 = {3,4,5,6};
        assertEquals(3.5, test.findMedianSortedArrays(num1, num2));

        num2 = new int[] {3,4,5,6,7};
        assertEquals(4, test.findMedianSortedArrays(num1, num2));
    }
}