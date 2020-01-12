package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1105_FillingBookcaseShelvesTest {
    Q1105_FillingBookcaseShelves test = new Q1105_FillingBookcaseShelves();

    @Test
    void minHeightShelves() {
        int[][] books = {{1,3}, {2,4}, {2,3}};
        assertEquals(4, test.minHeightShelves(books, 6));

        books = new int[][] {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        assertEquals(6, test.minHeightShelves(books, 4));
    }
}