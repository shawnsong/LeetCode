package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q279_PerfectSquaresTest {

    Q279_PerfectSquares test = new Q279_PerfectSquares();

    @Test
    void numSquares() {
        assertEquals(1, test.numSquares(1));
        assertEquals(2, test.numSquares(2));
        assertEquals(3, test.numSquares(3));
        assertEquals(1, test.numSquares(4));
        assertEquals(2, test.numSquares(5));
        assertEquals(3, test.numSquares(6));
        assertEquals(4, test.numSquares(7));
        assertEquals(1, test.numSquares(9));
        assertEquals(3, test.numSquares(12));

    }
}