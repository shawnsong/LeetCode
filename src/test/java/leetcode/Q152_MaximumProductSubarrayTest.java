package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q152_MaximumProductSubarrayTest {

    @Test
    void maxProduct() {
        Q152_MaximumProductSubarray test = new Q152_MaximumProductSubarray();
        assertEquals(12, test.maxProduct(new int[] {-4, -3, -2}));
        assertEquals(12, test.maxProduct(new int[] {-3, -2, 0, 3, 4}));
    }
}