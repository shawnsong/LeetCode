package leetcode;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;


public class Q044_WildcardMatchingTest {

    @Test
    public void isMatch() {
        Q044_WildcardMatching underTest  = new Q044_WildcardMatching();

        assertTrue(underTest.isMatch("adceb", "*a*b"));
    }
}
