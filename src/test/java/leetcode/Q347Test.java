package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Q347Test {
    Q347 test = new Q347();

    @Test
    void topKFrequent() {
        assertEquals(Arrays.asList(1, 2), test.topKFrequent(new int[] {1,1,1,2,2}, 1));
    }
}