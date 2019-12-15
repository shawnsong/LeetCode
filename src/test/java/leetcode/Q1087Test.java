package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q1087Test {

    Q1087 test = new Q1087();

    @Test
    void expand() {
        test.expand("{a,b}c{d,e}f");
    }
}