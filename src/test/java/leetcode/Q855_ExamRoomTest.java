package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q855_ExamRoomTest {
    @Test
    void test() {
        Q855_ExamRoom test = new Q855_ExamRoom(10);
        assertEquals(0, test.seat());
        assertEquals(9, test.seat());
        assertEquals(4, test.seat());
        assertEquals(2, test.seat());
        test.leave(4);
        assertEquals(5, test.seat());
    }
}