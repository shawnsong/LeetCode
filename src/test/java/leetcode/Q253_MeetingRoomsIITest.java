package leetcode;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q253_MeetingRoomsIITest {

    Q253_MeetingRoomsII test;
    Interval[] intervals;


    @BeforeEach
    void setup() {
        test = new Q253_MeetingRoomsII();
        intervals = new Interval[4];
        intervals[2] = new Interval(0, 30);
        intervals[1] = new Interval(10, 20);
        intervals[0] = new Interval(20, 40);
        intervals[3] = new Interval(35, 50);
    }

    @Test
    void minMeetingRooms() {
        assertEquals(2, test.minMeetingRooms(intervals));
    }

    @Test
    void minMeetingRooms2() {
        assertEquals(2, test.minMeetingRooms2(intervals));
    }
}