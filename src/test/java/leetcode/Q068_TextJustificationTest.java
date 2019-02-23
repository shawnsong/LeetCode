package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q068_TextJustificationTest {

    Q068_TextJustification underTest = new Q068_TextJustification();

    @Test
    void fullJustify() {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(underTest.fullJustify(words, 16));
    }
}