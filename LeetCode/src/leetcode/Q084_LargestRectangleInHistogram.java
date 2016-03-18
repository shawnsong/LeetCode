package leetcode;

public class Q084_LargestRectangleInHistogram {

	public int largestRectangleArea(int[] heights) {

		// self maintained stack
		int[] stack = new int[heights.length];
		int top = -1;

		int maxArea = 0;
		int i;
		for ( i = 0; i < heights.length; i++) {
			if (top < 0 || heights[stack[top]] < heights[i]) {
				top++;
				stack[top] = i;
			} else {
				while (top >= 0 && heights[stack[top]] >= heights[i]) {
					int h = heights[stack[top]];
					top--;
					if (top >= 0)
						maxArea = Math.max(maxArea, h * (i - stack[top] - 1));
					else
						maxArea = Math.max(maxArea, h * i);
					
				}
				top++;
				stack[top] = i;
			}
		}
        while (top >= 0) {
			int h = heights[stack[top]];
			top--;
			if (top >= 0)
				maxArea = Math.max(maxArea, h * (i - stack[top] - 1));
			else
				maxArea = Math.max(maxArea, h * i);
			
		}
		return maxArea;
	}
}
