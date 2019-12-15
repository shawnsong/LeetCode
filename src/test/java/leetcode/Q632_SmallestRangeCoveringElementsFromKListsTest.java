package leetcode;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Q632_SmallestRangeCoveringElementsFromKListsTest {
    Q632_SmallestRangeCoveringElementsFromKLists test = new Q632_SmallestRangeCoveringElementsFromKLists();

    @Test
    void smallestRange() {
        int[] res = test.smallestRange(Arrays.asList(Arrays.asList(-1, 1), Arrays.asList(1, 2)));
        assertEquals(res[0], 1);
        assertEquals(res[1], 1);
    }
}