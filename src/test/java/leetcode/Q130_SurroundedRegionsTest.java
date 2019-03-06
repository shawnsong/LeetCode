package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q130_SurroundedRegionsTest {

    Q130_SurroundedRegions undertest = new Q130_SurroundedRegions();

    @Test
    void solveDfs() {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'X'},
        };
        undertest.solveDfs(board);
    }
}