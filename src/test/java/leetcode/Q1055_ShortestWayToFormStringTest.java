package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1055_ShortestWayToFormStringTest {

    Q1055_ShortestWayToFormString test = new Q1055_ShortestWayToFormString();

    @Test
    void shortestWay() {
        assertEquals(2, test.shortestWay("abc", "abcbc"));
        assertEquals(-1, test.shortestWay("abc", "abdbc"));
        assertEquals(3, test.shortestWay("abc", "acbac"));

        assertEquals(2, test.shortestWay2("abc", "abcbc"));
        assertEquals(-1, test.shortestWay2("abc", "abdbc"));
        assertEquals(3, test.shortestWay2("abc", "acbac"));
    }
}