package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q029_DivideTwoIntegersTest {

    Q029_DivideTwoIntegers underTest = new Q029_DivideTwoIntegers();

    @Test
    void divide() {
//        for (int i = 0; i < 33; i++) {
//            System.out.println(1 << i);
//        }
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println( Integer.toBinaryString(Integer.MIN_VALUE >> 10));
        System.out.println( Integer.MIN_VALUE >> 31);

        System.out.println(underTest.divide(Integer.MAX_VALUE, 1));
    }
}