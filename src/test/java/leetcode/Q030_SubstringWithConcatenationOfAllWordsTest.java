package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Q030_SubstringWithConcatenationOfAllWordsTest {

    Q030_SubstringWithConcatenationOfAllWords underTest = new Q030_SubstringWithConcatenationOfAllWords();

    @Test
    void findSubstring() {
        String s  = "barfoothefoobarman";
        List<Integer> res = underTest.findSubstring(s, new String[] { "foo", "bar"} );
        assertTrue(res.contains(0));
        assertTrue(res.contains(9));
    }
}