package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q179_LargestNumberTest {

    Q179_LargestNumber underTest = new Q179_LargestNumber();

    @Test
    void largestNumber() {
        System.out.println(underTest.largestNumber(new int[] {3, 30, 34, 59, 9}));
        System.out.println("58".compareTo("59"));
    }
}