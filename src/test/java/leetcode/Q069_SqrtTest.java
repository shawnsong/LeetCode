package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q069_SqrtTest {

    Q069_Sqrt underTest = new Q069_Sqrt();
    @Test
    void mySqrt() {
        for (int i = 0; i < 100; i++)
            assertEquals((int)Math.sqrt(5), underTest.mySqrt(5));
    }
}