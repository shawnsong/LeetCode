package leetcode.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryIndexTreeTest {

    BinaryIndexTree test = new BinaryIndexTree();

    @Test
    void testBuildTree() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        int[] tree = test.buildTree(nums);

        assertEquals(6, test.getSum(tree, 2));
        assertEquals(3, test.getSum(tree, 1));
        assertEquals(1, test.getSum(tree, 0));
        assertEquals(10, test.getSum(tree, 3));
    }
}