package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q271_EncodeandDecodeStringsTest {

    Q271_EncodeandDecodeStrings test = new Q271_EncodeandDecodeStrings();

    @Test
    void encode() {
        assertEquals("2|ab".concat("3|a|c").concat("3||ac") , test.encode(Arrays.asList("ab", "a|c", "|ac"))) ;
    }

    @Test
    void decode() {
        assertEquals(Arrays.asList("ab", "a|c", "|ac"), test.decode("2|ab".concat("3|a|c").concat("3||ac")));
    }
}