package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q136_SingleNumberTest {

    Q136_SingleNumber underTest = new Q136_SingleNumber();

    @Test
    void singleNumber() {
        assertEquals(2, 3 ^ 1);
        assertEquals(5, 6 ^ 3);
        assertEquals(1, underTest.singleNumber(new int[] {1, 3, 3, 4, 4}));
    }
}