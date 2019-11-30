package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1231_DivideChocolateTest {
    Q1231_DivideChocolate test = new Q1231_DivideChocolate();

    @Test
    void maximizeSweetness() {
        assertEquals(19294, test.maximizeSweetness(new int[] {22256,47646,19294,31272,75367}, 4));
        assertEquals(6, test.maximizeSweetness(new int[] {1,2,3,4,5,6,7,8,9}, 5));
    }
}