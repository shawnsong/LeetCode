package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1088_ConfusingNumberIITest {
    Q1088_ConfusingNumberII test =  new Q1088_ConfusingNumberII();

    @Test
    void confusingNumberII() {
        // assertEquals(6, test.confusingNumberII(20));
        assertEquals(6, test.solution2(20));
        System.out.println(test.solution2(1000000000));;
//        assertEquals(6, test.solution2(20));
    }
}