package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q267_PalindromePermutationIITest {

    Q267_PalindromePermutationII test = new Q267_PalindromePermutationII();

    @Test
    void generatePalindromes() {
        System.out.println(test.generatePalindromes("aab"));
        System.out.println(test.generatePalindromes("aabbccc"));
    }
}