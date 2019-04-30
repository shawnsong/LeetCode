package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q957_PrisonCellsAfterNDaysTest {

    Q957_PrisonCellsAfterNDays test = new Q957_PrisonCellsAfterNDays();

    @Test
    void prisonAfterNDays() {
        test.prisonAfterNDays(new int[] {0,1,0,1,1,0,0,1}, 2);
    }
}