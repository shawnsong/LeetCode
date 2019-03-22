package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q031_NextPermutationTest {

    Q031_NextPermutation test = new Q031_NextPermutation();

    @Test
    void nextPermutation() {
        int[] num = {1, 2, 3, 4};
        test.nextPermutation(num);
        StringBuilder sb = new StringBuilder();
        for (int n : num) sb.append(n);
        assertEquals("1243", sb.toString());

        sb.setLength(0);
        num = new int[] {3,2,5,4,1};
        test.nextPermutation(num);
        for (int n : num) sb.append(n);
        assertEquals("34125", sb.toString());


    }
}