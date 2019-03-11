package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q252_MeetingRoomsTest {

    Q252_MeetingRooms test = new Q252_MeetingRooms();

    @Test
    void canAttendMeetings() {
        Interval[] intervals = new Interval[3];
        intervals[2] = new Interval(0, 30);
        intervals[1] = new Interval(30, 40);
        intervals[0] = new Interval(40, 50);
        assertTrue(test.canAttendMeetings(intervals));
    }
}