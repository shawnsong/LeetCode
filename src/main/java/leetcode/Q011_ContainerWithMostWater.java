package leetcode;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 *  n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 *  Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 *  Note: You may not slant the container.
 *
 */
public class Q011_ContainerWithMostWater {
	public int maxArea(int[] height) {
		if (height == null || height.length < 2) {
		    return  0;
        }

        int max = 0;
		int left = 0;
		int right = height.length - 1;

		while (left < right) {
		    int minHeight = Math.min(height[left], height[right]);

		    int area = minHeight * (right - left);

		    max = Math.max(max, area);
		    if (height[left] == minHeight) {
		        left++;
            } else {
		        right--;
            }
        }
		return max;
	}
}
