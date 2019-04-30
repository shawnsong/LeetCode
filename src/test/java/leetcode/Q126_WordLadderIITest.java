package leetcode;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q126_WordLadderIITest {

    Q126_WordLadderII test = new Q126_WordLadderII();

    @Test
    void findLadders() {

        System.out.println(test.findLadders("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
    }
}