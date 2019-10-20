package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1036_EscapeLargeMazeTest {
    Q1036_EscapeLargeMaze test = new Q1036_EscapeLargeMaze();

    @Test
    void isEscapePossible() {
        assertTrue(test.isEscapePossible(new int[][]{{0, 3}, {1, 0}, {1, 1}, {1, 2}, {1, 3}},
                new int[]{0, 0}, new int[]{0, 2}));
    }
}