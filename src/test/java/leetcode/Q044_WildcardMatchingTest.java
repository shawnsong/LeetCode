package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class Q044_WildcardMatchingTest {

    @Test
    public void isMatch() {
        Q044_WildcardMatching underTest  = new Q044_WildcardMatching();

        assertTrue(underTest.isMatch("adceb", "*a*b"));
    }
}
