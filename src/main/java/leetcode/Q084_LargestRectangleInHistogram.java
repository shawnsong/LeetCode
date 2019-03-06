package leetcode;

import java.util.Stack;

public class Q084_LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack();
        int maxArea = 0;
        int i = 0;
        for (; i < heights.length; i++) {
            if (stack.isEmpty() || heights[i] > heights[stack.peek()]) {
                stack.push(i);
                continue;
            }

            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int heightIndex = stack.pop();
                int height = heights[heightIndex];
                int width = 1;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                maxArea = Math.max(height * width, maxArea);
            }
            stack.push(i);

        }
        while (!stack.isEmpty()) {
            int heightIndex = stack.pop();
            int height = heights[heightIndex];
            int width = 1;
            if (stack.isEmpty()) {
                width = i;
            } else {
                width = i - stack.peek() -1;
            }
            maxArea = Math.max(height * width, maxArea);
        }
        return maxArea;
    }
}
