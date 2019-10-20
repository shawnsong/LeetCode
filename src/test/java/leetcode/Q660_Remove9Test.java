package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q660_Remove9Test {
    Q660_Remove9 test = new Q660_Remove9();

    @Test
    void newInteger() {
        assertEquals(10, test.newInteger(9));
        assertEquals(12, test.newInteger(11));
    }
}