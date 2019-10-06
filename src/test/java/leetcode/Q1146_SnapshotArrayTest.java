package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1146_SnapshotArrayTest {

    @Test
    void test() {
        Q1146_SnapshotArray test = new Q1146_SnapshotArray(3);
        test.set(0, 5);
        test.snap();
        test.set(0, 6);
        assertEquals(5, test.get(0, 0));
    }
}