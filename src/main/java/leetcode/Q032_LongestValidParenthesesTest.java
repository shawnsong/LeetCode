package leetcode;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class Q032_LongestValidParenthesesTest {

    @Test
    public void longestValidParentheses() {
        Q032_LongestValidParentheses test = new Q032_LongestValidParentheses();

        assertEquals(4, test.longestValidParentheses(")()())"));
        assertEquals(6, test.longestValidParentheses(")()()()"));
    }
}
