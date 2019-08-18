package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q837_New21GameTest {

    Q837_New21Game test = new Q837_New21Game();

    @Test
    void new21Game() {
        assertTrue(1 - test.new21Game(10, 1, 10) < 0.0001);
        assertTrue(0.6 - test.new21Game(6, 1, 10) < 0.0001);
        assertTrue(0.73278 - test.new21Game(21, 17, 10) < 0.0001);
    }
}