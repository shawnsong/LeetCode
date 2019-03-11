package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q189_RotateArrayTest {

    Q189_RotateArray test = new Q189_RotateArray();

    @Test
    void rotate1() {
        test.rotate1(new int[] {1, 2, 3, 4, 5}, 2);
    }

    @Test
    void findGcd() {
        System.out.println(test.findGcd(7, 2));
    }
}