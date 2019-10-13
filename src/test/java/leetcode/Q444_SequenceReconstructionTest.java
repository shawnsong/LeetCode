package leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Q444_SequenceReconstructionTest {
    Q444_SequenceReconstruction test = new Q444_SequenceReconstruction();

    @Test
    void sequenceReconstruction() {
        int[] org = {1,2,3};
        List<List<Integer>> subs = Arrays.asList(Arrays.asList(1,2), Arrays.asList(1,3));
        assertFalse(test.sequenceReconstruction(org, subs));

        assertTrue(test.sequenceReconstruction(org, Arrays.asList(
                Arrays.asList(1,2),
                Arrays.asList(1,3),
                Arrays.asList(2,3))
        ));

        assertTrue(test.sequenceReconstruction(new int[] {1,2}, Arrays.asList(Arrays.asList(1,2), Arrays.asList(1,2))));
    }
}