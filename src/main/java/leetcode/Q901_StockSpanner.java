package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q901_StockSpanner {
    Deque<DayPrice> deque;
    int day;
    public Q901_StockSpanner() {
        deque = new ArrayDeque<>();
        day = 0;
    }

    public int next(int price) {
        day++;
        int res = 1;
        while (deque.size() > 0 && price >= deque.peekLast().price) {
            deque.pollLast();
        }

        if (deque.size() == 0) {
            res = day;
        } else {
            res = day - deque.peekLast().day;
        }
        deque.add(new DayPrice(day, price));

        return res;
    }

    class DayPrice {
        int day;
        int price;
        DayPrice(int d, int p) {
            day = d;
            price = p;
        }
    }
}
