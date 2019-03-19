package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q295_FindMedianFromDataStreamTest {

    Q295_FindMedianFromDataStream test = new Q295_FindMedianFromDataStream();

    @Test
    void findMedian() {
        double median = 0.5;
        for (int i = 0; i < 10; i++) {
            test.addNum(i);
            assertEquals(median * i, test.findMedian());
        }

    }
}