package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q302_SmallestRectangleEnclosingBlackPixelsTest {

    Q302_SmallestRectangleEnclosingBlackPixels test = new Q302_SmallestRectangleEnclosingBlackPixels();
    @Test
    void minArea() {

        char[][] image = {
            {'0', '0', '1', '0'},
            {'0', '1', '1', '0'},
            {'0', '1', '0', '0'}};
        int area = test.minArea(image, 1, 1);
        assertEquals(6, area);
    }
}