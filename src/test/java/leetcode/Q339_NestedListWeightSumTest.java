package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import leetcode.models.NestedInteger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q339_NestedListWeightSumTest {

    Q339_NestedListWeightSum underTest = new Q339_NestedListWeightSum();

    @Test
    void testDfs() {
        List<NestedInteger> list = new LinkedList<>();
        NestedInteger node = new NestedInteger();
        node.getList().addAll(Arrays.asList(new NestedInteger(1), new NestedInteger(1)));
        list.add(node);

        list.add(new NestedInteger(2));
        node = new NestedInteger();
        node.getList().addAll(Arrays.asList(new NestedInteger(1), new NestedInteger(1)));
        list.add(node);

        assertEquals(10, underTest.depthSum(list));
    }

    @Test
    void testBfs() {
        List<NestedInteger> list = new LinkedList<>();
        NestedInteger node = new NestedInteger();
        node.getList().addAll(Arrays.asList(new NestedInteger(1), new NestedInteger(1)));
        list.add(node);

        list.add(new NestedInteger(2));
        node = new NestedInteger();
        node.getList().addAll(Arrays.asList(new NestedInteger(1), new NestedInteger(1)));
        list.add(node);

        assertEquals(10, underTest.bfs(list));
    }
}