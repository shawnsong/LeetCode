package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q269_AlienDictionaryTest {

    Q269_AlienDictionary test = new Q269_AlienDictionary();

    @Test
    void alienOrder() {
        String[] words = {"wrt", "wrf", "er", "et", "rtff"};
        assertEquals("wertf", test.alienOrder(words));
    }
}