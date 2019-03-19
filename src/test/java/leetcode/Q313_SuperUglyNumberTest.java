package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q313_SuperUglyNumberTest {

    @Test
    void nthSuperUglyNumber() {
        int n = 12;
        int[] primes = { 2, 3, 5, 7 };

        Q313_SuperUglyNumber obj = new Q313_SuperUglyNumber();

        int num = obj.nthSuperUglyNumber(12, primes);
        System.out.println(num);
    }
}