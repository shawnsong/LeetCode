package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q957_PrisonCellsAfterNDays {

    public int[] prisonAfterNDays(int[] cells, int n) {
        if (n <= 0) return cells;

        Map<String, Integer> seen = new HashMap<>();

        while (n > 0) {
            int[] next = new int[8];
            String cellsStr = Arrays.toString(cells);
            if (seen.containsKey(cellsStr)) {
                int cycleSize = seen.get(cellsStr) - n;
                n = n % cycleSize;
                break;
            } else {
                seen.put(cellsStr, n);
            }

            for (int i = 1; i < 7; i++)
                next[i] = cells[i-1] == cells[i+1] ? 1 : 0;
            cells = next;
            n--;
        }
        while (n > 0) {
            int[] next = new int[8];
            for (int i = 1; i < 7; i++)
                next[i] = cells[i-1] == cells[i+1] ? 1 : 0;
            n--;
            cells = next;
        }
        return cells;
    }


}
