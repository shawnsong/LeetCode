package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q849Test {
    Q849 test = new Q849();

    @Test
    void maxDistToClosest() {
        assertEquals(1, test.maxDistToClosest(new int[] {1, 0}));
    }
}