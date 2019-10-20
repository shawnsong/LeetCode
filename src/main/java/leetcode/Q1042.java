package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Q1042 {
    public int[] gardenNoAdj(int n, int[][] paths) {
        int[] colors = new int[n];
        ArrayList<Integer>[] nexts = new ArrayList[n + 1];
        for (int i = 0 ; i <= n; i++) {
            nexts[i] = new ArrayList();
        }
        for(int[] path : paths) {
            nexts[path[0]].add(path[1]);
            nexts[path[1]].add(path[0]);
        }
        for (int i = 1; i <= n; i++) {
            Set<Integer> set = new HashSet<>(Arrays.asList(1, 2, 3, 4));
            for (int next : nexts[i]) {
                set.remove(colors[next - 1]);
            }
            colors[i - 1] = set.iterator().next();
        }
        return colors;
    }
}
