package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q013_ROmanToIntegerTest {

    Q013_ROmanToInteger underTest = new Q013_ROmanToInteger();

    @Test
    void romanToInt() {

        assertEquals(44, underTest.romanToInt("XLIV"));
        assertEquals(98, underTest.romanToInt("XCVIII"));
    }
}