package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Q399_EvaluateDIvisionTest {

    Q399_EvaluateDIvision test = new Q399_EvaluateDIvision();

    @Test
    void calcEquation() {
        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList( Arrays.asList("a", "c"),
                Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x") );

        double[] res = test.calcEquation(equations, values, queries);
        double[] expected = new double[]{6.0, 0.5, -1.0, 1.0, -1.0};
        for (int i = 0; i < res.length; i++) {
            assertEquals(expected[i], res[i]);
        }
    }
}