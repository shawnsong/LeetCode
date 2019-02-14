package leetcode;

/*
 Smallest Rectangle Enclosing Black Pixels
 An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel. 
 The black pixels are connected, i.e., there is only one black region. 
 Pixels are connected horizontally and vertically. 
 Given the location (x, y) of one of the black pixels, return the area of the 
 smallest (axis-aligned) rectangle that encloses all black pixels.
 
 For example, given the following image:
 [
 "0010",
 "0110",
 "0100"
 ]
 and x = 0, y = 2,
 Return 6.

 */

public class Q302_SmallestRectangleEnclosingBlackPixels {
	int left, right, top, bottom;
	
	int[][] steps = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	public int minArea(char[][] image, int x, int y) {
		
		if (image == null || image.length == 0)
			return 0;
		left = image[0].length;
		right = 0;
		top = image.length;
		bottom = 0;
		walkAround(image, x, y);
		
		return (right - left + 1) * (bottom - top + 1);
	}
	
	private void walkAround(char[][] image, int x, int y) {
		if (x < 0 || x >= image[0].length || y < 0 || y >= image.length)
			return;
		
		if (image[y][x] == '0' || image[y][x] == '2')
			return;
		
		image[y][x] = '2';
		left = Math.min(left, x);
		right = Math.max(right, x);
		top = Math.min(top,  y);
		bottom = Math.max(bottom, y);
		
		for (int i = 0; i < steps.length; i++) {
			int x1 = x + steps[i][0];
			int y1 = y + steps[i][1];
			walkAround(image, x1, y1);
		}
	}
	
	// test
	public static void main(String[] ar) {
		Q302_SmallestRectangleEnclosingBlackPixels o = new Q302_SmallestRectangleEnclosingBlackPixels();
		char[][] image = {{'0', '0', '1', '0'}, {'0', '1', '1', '0'}, {'0', '1', '0', '0'}};
		int area = o.minArea(image, 1, 1);
		System.out.println(area);
	}
}
