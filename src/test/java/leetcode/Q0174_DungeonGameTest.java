package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q0174_DungeonGameTest {

    Q0174_DungeonGame test = new Q0174_DungeonGame();
    @Test
    void minHp() {
        int[][] board = {
            { 1,  -2,  -5,  -4},
            { -1, -5,  10,   1},
            { -2,  1,  -3,   0}
        };

        assertEquals(5, test.minHp(board));
    }
}