package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Q118_PascalsTriangleTest {

    Q118_PascalsTriangle underTest = new Q118_PascalsTriangle();

    @Test
    void generate() {
        List<List<Integer>> list = underTest.generate(5);
        System.out.println(list);
    }
}