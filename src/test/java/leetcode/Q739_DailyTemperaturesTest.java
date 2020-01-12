package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q739_DailyTemperaturesTest {
    Q739_DailyTemperatures test = new Q739_DailyTemperatures();

    @Test
    void dailyTemperatures() {
        assertArrayEquals(new int[] {1,1,4,2,1,1,0,0}, test.dailyTemperatures(new int[] {73,74,75,71,69,72,76,73}));
    }
}