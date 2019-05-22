package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leetcode.models.NestedInteger;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 *
 * Input: [[1,1],2,[1,1]]
 * Output: 10
 * Explanation: Four 1's at depth 2, one 2 at depth 1.
 * Example 2:
 *
 * Input: [1,[4,[6]]]
 * Output: 27
 * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
 */
public class Q339_NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null)
            return 0;
        int sum = 0;
        for (NestedInteger node : nestedList) {
            sum += dfs(node, 1);
        }

        return sum;
    }

    int dfs(NestedInteger root, int level) {
        if (root.isInteger()) return root.getInteger() * level;

        int sum = 0;
        for (NestedInteger child : root.getList()) {
            sum += dfs(child, level + 1);
        }
        return sum;
    }

    int bfs(List<NestedInteger> list) {
        Queue<NestedInteger> queue = new LinkedList<>();

        int level = 1;
        queue.addAll(list);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger integer = queue.poll();
                if (integer.isInteger()) {
                    sum += integer.getInteger() * level;
                } else {
                    queue.addAll(integer.getList());
                }
            }
            level++;
        }
        return sum;
    }
}
