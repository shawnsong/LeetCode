package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q301_RemoveInvalidParenthesesTest {

    Q301_RemoveInvalidParentheses test = new Q301_RemoveInvalidParentheses();

    @Test
    void removeInvalidParentheses() {

        System.out.println(test.removeInvalidParentheses("()())"));
        System.out.println(test.removeInvalidParentheses("()())())"));
    }
}