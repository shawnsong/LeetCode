package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q668_KthSmallestNumberInMultiplicationTableTest {
    Q668_KthSmallestNumberInMultiplicationTable test = new Q668_KthSmallestNumberInMultiplicationTable();

    @Test
    void findKthSmallest() {
        assertEquals(3, test.findKthSmallest(3,3,5));
    }
}