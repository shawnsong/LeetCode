package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Q281_ZigzagIteratorTest {

    @Test
    void test() {
        Q281_ZigzagIterator test = new Q281_ZigzagIterator(
                Arrays.asList(2, 4, 5, 7, 8),
                Arrays.asList(1, 3)
        );
        while (test.hasNext()) {
            System.out.print(test.next());
        }
    }
}