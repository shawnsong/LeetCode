package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q008_StringToIntegerAToITest {

    Q008_StringToIntegerAToI underTest = new Q008_StringToIntegerAToI();

    @Test
    void testMyAtoi() {

        assertEquals(0, underTest.myAtoi( " +-"));
        assertEquals(-1, underTest.myAtoi( " +-1"));
        assertEquals(-12, underTest.myAtoi( " +-12"));
        assertEquals(12, underTest.myAtoi( " 12"));
        assertEquals(12, underTest.myAtoi( " 12dds"));
        assertEquals(12, underTest.myAtoi( " ffd-=12dds"));
        assertEquals(987, underTest.myAtoi( " words and 987"));

    }
}