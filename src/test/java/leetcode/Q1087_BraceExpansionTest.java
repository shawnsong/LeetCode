package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1087_BraceExpansionTest {
    Q1087_BraceExpansion test = new Q1087_BraceExpansion();

    @Test
    void expand() {
        assertEquals(1, test.expand("abc").length);
        String[] res = test.expand("{a,b}c{d,e}f");
        System.out.println(res);
    }
}