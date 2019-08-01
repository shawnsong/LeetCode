package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Q218_TheSkylineProblemTest {

    Q218_TheSkylineProblem test = new Q218_TheSkylineProblem();

    @Test
    void getSkyline() {

        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        List<List<Integer>> res = test.getSkyline(buildings);
        assertEquals(res, Arrays.asList(Arrays.asList(2, 10), Arrays.asList(3, 15), Arrays.asList(7, 12),
                Arrays.asList(12, 0), Arrays.asList(15, 10), Arrays.asList(20, 8), Arrays.asList(24, 0)));
    }
}