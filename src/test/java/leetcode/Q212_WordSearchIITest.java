package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Q212_WordSearchIITest {
    Q212_WordSearchII test = new Q212_WordSearchII();

    @Test
    void findWords() {
        char[][] board = {
          {'o','a','a','n'},
          {'e','t','a','e'},
          {'i','h','k','r'},
          {'i','f','l','v'}
        };
        String[] words = {"oath","pea","eat","rain"};
        assertEquals(Arrays.asList("oath", "eat"), test.findWords(board, words));
    }
}