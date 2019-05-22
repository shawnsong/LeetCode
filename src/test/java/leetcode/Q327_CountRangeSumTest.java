package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q327_CountRangeSumTest {

    Q327_CountRangeSum test = new Q327_CountRangeSum();

    @Test
    void countRangeSum() {
        test.countRangeSum(new int[] {-3,1,2,-2,2,-1}, -3, -1);
    }
}