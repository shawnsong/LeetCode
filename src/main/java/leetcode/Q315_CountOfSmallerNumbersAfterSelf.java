package leetcode;

import java.util.Arrays;
import java.util.List;

public class Q315_CountOfSmallerNumbersAfterSelf {
    class Node {
        Node left;
        Node right;
        int sum;
        int val;
        int dup;
        Node(int s, int v) {
            sum = s;
            val = v;
            dup = 1;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Arrays.asList(0);
        }

        Node root = null;
        Integer[] res = new Integer[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, res, i, 0);
        }
        return Arrays.asList(res);
    }

    private Node insert(int num, Node node, Integer[] res, int i, int preSum) {
        if (node == null) {
            node = new Node(0, num);
            res[i] = preSum;
        } else if (node.val == num) {
            node.dup++;
            res[i] = preSum + node.sum;
        } else if (num < node.val) {
            node.sum++;
            node.left = insert(num, node.left, res, i, preSum);
        } else {
            node.right = insert(num, node.right, res, i, preSum + node.sum + node.dup);
        }
        return node;
    }
}
