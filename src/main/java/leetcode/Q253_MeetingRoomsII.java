package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q253_MeetingRoomsII {

    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int end = 0;
        int res = 0;
        for (int i = 0; i < starts.length; i++) {
            if (starts[i] < ends[end]) {
                res++;
            } else {
                end++;
            }
        }
        return res;
    }

    public int minMeetingRooms2(Interval[] intervals) {
        PriorityQueue<Integer> endsQueue = new PriorityQueue<>();
        for (Interval interval : intervals) {
            endsQueue.add(interval.end);
        }

        Arrays.sort(intervals, Comparator.comparingInt(i -> i.start));
        int res = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i].start < endsQueue.peek()) {
                res++;
            } else {
                endsQueue.poll();
            }
        }
        return res;
    }
}
