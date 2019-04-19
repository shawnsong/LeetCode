package leetcode;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q057_InsertIntervalTest {

    Q057_InsertInterval test = new Q057_InsertInterval();

    @Test
    void insertInterval() {

        List<Interval> intervals = Arrays.asList(
            new Interval(1, 2),
            new Interval(3, 4),
            new Interval(7, 8),
            new Interval(12, 14)
            );
        List<Interval> res = test.insertInterval(intervals, new Interval(9, 10));
        System.out.println(res);
    }
}