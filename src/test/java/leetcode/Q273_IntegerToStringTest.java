package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q273_IntegerToStringTest {

    Q273_IntegerToString test = new Q273_IntegerToString();

    @Test
    void numberToWords() {
        System.out.println(test.numberToWords(123));
        System.out.println(test.numberToWords(1234));
    }
}