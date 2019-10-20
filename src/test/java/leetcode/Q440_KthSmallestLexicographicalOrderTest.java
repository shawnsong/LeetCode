package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q440_KthSmallestLexicographicalOrderTest {
    Q440_KthSmallestLexicographicalOrder test = new Q440_KthSmallestLexicographicalOrder();

    @Test
    void findKthNumber() {
        System.out.println(test.findKthNumber(130, 25));
    }

    @Test
    void testFindSteps() {
        assertEquals(5, test.calStepsToRight(13, 1, 2));
        assertEquals(11, test.calStepsToRight(20, 1, 2));
    }
}