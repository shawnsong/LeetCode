package leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Q251_Flatten2DVectorTest {

    @Test
    void next() {
        List<List<Integer>> list = new LinkedList<>();
        list.add(Arrays.asList(1, 2, 3));
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3,2));

        Q251_Flatten2DVector test = new Q251_Flatten2DVector(list);
        while (test.hasNext()) {
            System.out.println(test.next());
        }
    }

}