package leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

class Q300_1GetLISTest {
    Q300_1GetLIS test = new Q300_1GetLIS();

    @Test
    void getLIS() {
        List<List<Integer>> res = test.getLIS(new int[] {2,3,1,3,4});
        System.out.println(res);
    }
}