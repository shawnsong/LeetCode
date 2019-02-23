package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q067_AddBinaryTest {

    Q067_AddBinary underTest = new Q067_AddBinary();
    @Test
    void addBinary() {
        assertEquals("100", underTest.addBinary("11", "1"));
        assertEquals("1010", underTest.addBinary("11", "111"));
    }
}