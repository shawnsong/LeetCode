package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q743_NetworkDelayTimeTest {
    Q743_NetworkDelayTime test = new Q743_NetworkDelayTime();

    @Test
    void networkDelayTime() {
        assertEquals(3, test.networkDelayTime(new int[][] {{1,2,1}, {2,3,2}, {1,3,4}}, 3, 1));
    }
}