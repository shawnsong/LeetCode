package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Q425_WordSquaresTest {
    Q425_WordSquares test = new Q425_WordSquares();

    @Test
    void wordSquares() {
        System.out.println(test.wordSquares(new String[] {"area","lead","wall","lady","ball"}));
        assertEquals(Arrays.asList(Arrays.asList("wall", "area", "lead", "lady"), Arrays.asList("ball", "area", "lead", "lady")),
                test.wordSquares(new String[] {"area","lead","wall","lady","ball"}));

    }
}