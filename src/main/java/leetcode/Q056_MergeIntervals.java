package leetcode;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class Q056_MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new LinkedList<>();

        intervals.sort(Comparator.comparingInt(i -> i.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start > end) {
                res.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            } else {
                end = Math.max(end, interval.end);
            }
        }
        res.add(new Interval(start, end));

        return res;
    }
}
