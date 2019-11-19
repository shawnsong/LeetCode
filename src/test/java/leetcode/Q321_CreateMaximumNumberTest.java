package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q321_CreateMaximumNumberTest {
    Q321_CreateMaximumNumber test = new Q321_CreateMaximumNumber();
    @Test
    void maxNumber() {
        /**
         *
         [3,4,6,5]
         [9,1,2,5,8,3]
         5
         */
        int[] nums1 = {6,7};
        int[] nums2 = {6,0,4};
        test.maxNumber(nums1, nums2, 5);
    }
}