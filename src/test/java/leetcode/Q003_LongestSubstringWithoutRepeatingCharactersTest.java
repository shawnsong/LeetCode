package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q003_LongestSubstringWithoutRepeatingCharactersTest {

    Q003_LongestSubstringWithoutRepeatingCharacters underTest = new Q003_LongestSubstringWithoutRepeatingCharacters();

    @Test
    void lengthOfLongestSubstring() {
        assertEquals(underTest.lengthOfLongestSubstring("a"), 1);
        assertEquals(underTest.lengthOfLongestSubstring("abba"), 2);
        assertEquals(underTest.lengthOfLongestSubstring("pwwkew"), 3);
        assertEquals(underTest.lengthOfLongestSubstring("pwwkewp"), 4);
    }

    @Test
    void lengthOfLongestSubstring2() {
        assertEquals(underTest.lengthOfLongestSubstring2("a"), 1);
        assertEquals(underTest.lengthOfLongestSubstring2("abba"), 2);
        assertEquals(underTest.lengthOfLongestSubstring2("pwwkew"), 3);
    }
}