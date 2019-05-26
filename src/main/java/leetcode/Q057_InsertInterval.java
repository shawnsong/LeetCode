package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Q057_InsertInterval {

    public List<Interval> insertInterval(List<Interval> intervals, Interval newInterval) {

//        intervals.add(newInterval);
//        intervals.sort(Comparator.comparingInt(i -> i.start));

        List<Interval> res = new LinkedList<>();

        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i));
            i++;
        }

        int start = newInterval.start, end = newInterval.end;
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
            start = Math.min(intervals.get(i).start, start);
            end = Math.max(intervals.get(i).end, end);
            i++;
        }
        res.add(new Interval(start, end));

        while (i < intervals.size()) {
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }
}
