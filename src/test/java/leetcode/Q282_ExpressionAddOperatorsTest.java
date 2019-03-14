package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Q282_ExpressionAddOperatorsTest {

    Q282_ExpressionAddOperators test = new Q282_ExpressionAddOperators();
    @Test
    void addOperators() {
        List<String> list = test.addOperators("105", 5);
        assertEquals(Arrays.asList("1*0+5", "10-5"), list);
    }
}