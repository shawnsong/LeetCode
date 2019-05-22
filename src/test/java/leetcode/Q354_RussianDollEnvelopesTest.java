package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q354_RussianDollEnvelopesTest {

    Q354_RussianDollEnvelopes test = new Q354_RussianDollEnvelopes();
    @Test
    void maxEnvelopes() {
        int[][] envs = {{5,4},{6,4},{6,7},{2,3}};
        assertEquals(3, test.maxEnvelopes(envs));
        
        envs = new int[][] {{4,5},{4,6},{6,7},{2,3},{1,1},{1,1}};
        assertEquals(4, test.maxEnvelopes(envs));
    }
}