package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q772_BasicCalculatorTest {

    Q772_BasicCalculator test = new Q772_BasicCalculator();

    @Test
    void calculate() {

        assertEquals(2, test.calculate("1 + 1"));

        assertEquals(0, test.calculate("1 + (2-1*3)"));

        assertEquals(11, test.calculate("(7) - (0) + (4)"));

        assertEquals(0, test.calculate("-1+4*3/3/3"));
    }
}