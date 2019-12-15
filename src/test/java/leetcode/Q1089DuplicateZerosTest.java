package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q1089DuplicateZerosTest {
    Q1089_DuplicateZeros test = new Q1089_DuplicateZeros();

    @Test
    void duplicateZeros() {
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        test.duplicateZeros(arr);
        assertEquals(1, arr[0]);
        assertEquals(0, arr[1]);
        assertEquals(0, arr[2]);
        assertEquals(2, arr[3]);
        assertEquals(3, arr[4]);
        assertEquals(0, arr[5]);
        assertEquals(0, arr[6]);
        assertEquals(4, arr[7]);
    }
}
