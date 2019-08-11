package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Q524_LongestWordInDictionaryTest {

    Q524_LongestWordInDictionary test = new Q524_LongestWordInDictionary();

    @Test
    void findLongestWord() {
        assertEquals("apple", test.findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea")));
    }

    @Test
    void isSubsequence() {
        assertTrue(test.isSubsequence("abpcplea", "apple"));
        assertFalse(test.isSubsequence("abpcplea", "aclla"));
    }
}