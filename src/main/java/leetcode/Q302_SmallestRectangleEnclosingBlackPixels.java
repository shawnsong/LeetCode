package leetcode;

/**
 * Smallest Rectangle Enclosing Black Pixels
 * An image is represented by a binary matrix with 0 as a white pixel and 1 as a black pixel.
 * The black pixels are connected, i.e., there is only one black region.
 * Pixels are connected horizontally and vertically.
 * Given the location (x, y) of one of the black pixels, return the area of the
 * smallest (axis-aligned) rectangle that encloses all black pixels.
 *
 * For example, given the following image:
 * [
 *  "0010",
 *  "0110",
 *  "0100"
 * ]
 * and x = 0, y = 2,
 * Return 6.
 */
public class Q302_SmallestRectangleEnclosingBlackPixels {
	int left, right, top, bottom;

	public int minArea(char[][] image, int x, int y) {
		int m = image.length, n = image[0].length;
		left = n;
		right = 0;
		top = m;
		bottom = 0;
		for (int i = 0; i < image.length; i++) {
			int tmpRes = search(image, i, 0, y, true, true);
			left = Math.min(left, tmpRes);
			tmpRes = search(image, i, left, n-1, false, true);
			right = Math.max(right, tmpRes);
		}

		for (int i = 0; i < image[0].length; i++) {
			int tmpRes = search(image, i, 0, x, true, false);
			top = Math.min(top, tmpRes);
			tmpRes = search(image, i, top, m - 1, false, false);
			bottom = Math.max(bottom, tmpRes);
		}

		return (right - left + 1) * (bottom- top + 1);
	}

	private int search(char[][] image, int index, int low, int high, boolean searchLow, boolean searchRow) {
		char[] arr;
		if (searchRow) {
			arr = image[index];
		} else {
			arr = new char[image.length];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = image[i][index];
			}
		}

		if (searchLow) {
			while (low <= high) {
				int mid = low + (high - low) / 2;
				if (arr[mid] == '1') {
					high = mid - 1;
				} else {
					low = mid + 1;
				}
			}
			return low;
		} else {
			while (low <= high) {
				int mid = low + (high - low) / 2;
				if (arr[mid] == '1') {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
			}
			return low - 1;
		}
	}

//	public int minArea(char[][] image, int x, int y) {
//
//		if (image == null || image.length == 0)
//			return 0;
//		left = image[0].length;
//		right = 0;
//		top = image.length;
//		bottom = 0;
//		walkAround(image, x, y);
//		return (right - left + 1) * (bottom - top + 1);
//	}
//
//	private void walkAround(char[][] image, int rowIdx, int colIdx) {
//		if (rowIdx < 0 || rowIdx == image.length || colIdx < 0 || colIdx == image[0].length) {
//			return;
//		}
//		if (image[rowIdx][colIdx] != '1') {
//			return;
//		}
//		image[rowIdx][colIdx] = '2';
//		left = Math.min(left, colIdx);
//		right = Math.max(right, colIdx);
//		top = Math.min(top, rowIdx);
//		bottom = Math.max(bottom, rowIdx);
//
//		walkAround(image, rowIdx + 1, colIdx);
//		walkAround(image, rowIdx - 1, colIdx);
//		walkAround(image, rowIdx, colIdx + 1);
//		walkAround(image, rowIdx, colIdx - 1);
//	}
}
