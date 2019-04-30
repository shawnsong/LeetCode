package leetcode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q253_MeetingRoomsIITest {

    Q253_MeetingRoomsII test;
    Interval[] intervals;

    /**
     * 0         10
     * \__________\            20
     *       \_________________\         40
     *       5  \________________________\
     *          9   \__\  \__\
     *              11 15 16 19
     */
    @BeforeEach
    void setup() {
        test = new Q253_MeetingRoomsII();
        intervals = new Interval[5];
        intervals[2] = new Interval(0, 10);
        intervals[1] = new Interval(5, 20);
        intervals[0] = new Interval(9, 30);
        intervals[3] = new Interval(11, 15);
        intervals[4] = new Interval(16, 19);
    }

    @Test
    void minMeetingRooms() {
        assertEquals(3, test.minMeetingRooms(intervals));
    }

    @Test
    void minMeetingRooms2() {
        assertEquals(3, test.minMeetingRooms2(intervals));
    }
}