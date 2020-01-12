package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q901_StockSpannerTest {
    Q901_StockSpanner test = new Q901_StockSpanner();

    @Test
    void next() {
        assertEquals(1, test.next(100));
        assertEquals(1, test.next(80));
        assertEquals(1, test.next(60));
        assertEquals(2, test.next(70));
        assertEquals(1, test.next(60));
        assertEquals(4, test.next(75));
        assertEquals(6, test.next(85));
    }
}