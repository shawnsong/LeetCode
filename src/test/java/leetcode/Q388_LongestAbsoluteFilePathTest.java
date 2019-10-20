package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q388_LongestAbsoluteFilePathTest {
    Q388_LongestAbsoluteFilePath test = new Q388_LongestAbsoluteFilePath();

    @Test
    void test() {
        System.out.println(test.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}