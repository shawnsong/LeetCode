package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q451_SortCharactersByFrequencyTest {

    Q451_SortCharactersByFrequency underTest = new Q451_SortCharactersByFrequency();

    @Test
    void frequencySort() {
        String str = "eeeee";
        System.out.println(underTest.frequencySort(str));
    }
}