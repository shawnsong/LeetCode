package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Q736_EvaluateLispTest {

    Q736_EvaluateLisp test = new Q736_EvaluateLisp();

    @Test
    void evaluate() {
        String exp = "2";
        assertEquals(2, test.evaluate(exp));

        exp = "(add 1 2)";
        assertEquals(3, test.evaluate(exp));

        exp = "(mult 1 2)";
        assertEquals(2, test.evaluate(exp));

        exp = "(mult 3 (add 2 3))";
        assertEquals(15, test.evaluate(exp));

        exp = "(let x 2 (mult x 5))";
        assertEquals(10, test.evaluate(exp));

        exp = "(let x 2 (mult x (let x 3 y 4 (add x y))))";
        assertEquals(14, test.evaluate(exp));

        exp = "(let x 3 x 2 x)";
        assertEquals(2, test.evaluate(exp));

        exp = "(let x 1 y 2 x (add x y) (add x y))";
        assertEquals(5, test.evaluate(exp));

        exp = "(let x 2 (add (let x 3 (let x 4 x)) x))";
        assertEquals(6, test.evaluate(exp));

        exp = "(let a1 3 b2 (add a1 1) b2)";
        assertEquals(4, test.evaluate(exp));
    }

    @Test
    void testParse() {
        String exp = "1 2";

        assertEquals(Arrays.asList("1", "2"), test.parse(exp));

        exp = "3 (add 2 3)";
        assertEquals(Arrays.asList("3", "(add 2 3)"), test.parse(exp));

        exp = "x 2 (mult x (let x 3 y 4 (add x y)))";
        assertEquals(Arrays.asList("x", "2", "(mult x (let x 3 y 4 (add x y)))"), test.parse(exp));

        exp = "(let x 2 (add (let x 3 (let x 4 x)) x))";
        test.parse(exp);
    }
}