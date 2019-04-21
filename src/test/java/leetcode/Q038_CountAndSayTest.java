package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q038_CountAndSayTest {

    Q038_CountAndSay test = new Q038_CountAndSay();

    @Test
    void countAndSay() {
    }

    @Test
    void generateNext() {
        assertEquals("11", test.generateNext("1"));
        assertEquals("21", test.generateNext("11"));
        assertEquals("1211", test.generateNext("21"));
    }
}