package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q006_ZigZagConversionTest {

    Q006_ZigZagConversion underTest = new Q006_ZigZagConversion();

    @Test
    void convert() {
        assertEquals("A", underTest.convert("A", 1));
        assertEquals("ACB", underTest.convert("ABC", 2));
        assertEquals("PAHNAPLSIIGYIR", underTest.convert("PAYPALISHIRING", 3));
    }
}