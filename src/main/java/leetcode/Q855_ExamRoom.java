package leetcode;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * In an exam room, there are N seats in a single row, numbered 0, 1, 2, ..., N-1.
 *
 * When a student enters the room, they must sit in the seat that maximizes the distance to the closest person.
 * If there are multiple such seats, they sit in the seat with the lowest number.
 * (Also, if no one is in the room, then the student sits at seat number 0.)
 *
 * Return a class ExamRoom(int N) that exposes two functions: ExamRoom.seat() returning an int representing what seat the student sat in,
 * and ExamRoom.leave(int p) representing that the student in seat number p now leaves the room.
 * It is guaranteed that any calls to ExamRoom.leave(p) have a student sitting in seat p.
 */
public class Q855_ExamRoom {

    int n;
    PriorityQueue<Interval> pq;

    public Q855_ExamRoom(int N) {
        n = N;
        this.pq = new PriorityQueue<>((i1, i2) -> {
            if (i1.dist != i2.dist) {
                return i2.dist - i1.dist;
            }
            return i1.left - i2.left;
        });
        pq.add(new Interval(-1, n));
    }

    public int seat() {
        Interval interval = pq.poll();
        int seat;
        if (interval.left == -1) {
            seat = 0;
        } else if (interval.right == n) {
            seat = n - 1;
        } else {
            seat = interval.left + (interval.right - interval.left) / 2;
        }
        pq.add(new Interval(interval.left, seat));
        pq.add(new Interval(seat, interval.right));
        return seat;
    }

    public void leave(int p) {
        Interval head = null, tail = null;
        ArrayList<Interval> list = new ArrayList<>(pq);
        for (Interval interval : list) {
            if (interval.right == p) {
                head = interval;
            }
            if (interval.left == p) {
                tail = interval;
            }
            if (head != null && tail != null) {
                break;
            }
        }

        Interval merged = new Interval(head.left, tail.right);

        pq.remove(tail);
        pq.remove(head);

        pq.add(merged);

    }

    class Interval {
        int left;
        int right;
        int dist;
        Interval (int l, int r) {
            left = l;
            right = r;
            if (left == -1) {
                dist = right;
            } else if (r == n) {
                dist = n - left - 1;
            } else {
                dist = (right - left) / 2;
            }
        }
    }
}
