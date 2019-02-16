package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q007_ReverseIntegerTest {

    @Test
    void testReverse() {

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

        Q007_ReverseInteger underTest = new Q007_ReverseInteger();

        //  2147483647
        // -2147483648
        // -1563847412
        int res = underTest.reverse(-1563847412);
    }
}