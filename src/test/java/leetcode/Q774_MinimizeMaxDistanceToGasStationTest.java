package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q774_MinimizeMaxDistanceToGasStationTest {
    Q774_MinimizeMaxDistanceToGasStation test = new Q774_MinimizeMaxDistanceToGasStation();

    @Test
    void minMaxGasDist() {
        assertTrue(test.minMaxGasDist(new int[] {1,2,3,4,5,6,7,8,9}, 9) - 0.5 < 0.00001);
    }

}