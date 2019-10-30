package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q394_DecodeStringTest {
    private Q394_DecodeString test = new Q394_DecodeString();

    @Test
    void decodeString() {
        assertEquals("accaccacc", test.decodeString("3[a2[c]]"));
        assertEquals("aaa", test.decodeString("3[a]"));
        assertEquals("aaabcbc", test.decodeString("3[a]2[bc]"));
    }
}