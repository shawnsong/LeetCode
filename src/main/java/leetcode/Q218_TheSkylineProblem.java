package leetcode;

import java.util.*;

public class Q218_TheSkylineProblem {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int len = buildings.length;
        Height[] heights = new Height[len * 2];

        int i = 0;
        for (int[] b : buildings) {
            heights[i] = new Height(b[0], b[2], -1);
            i++;
            heights[i] = new Height(b[1], b[2], 1);
            i++;
        }

        Arrays.sort(heights, (h1, h2) -> {
            if (h1.pos != h2.pos) {
                return h1.pos - h2.pos;
            }
            if (h1.type == h2.type) {
                if (h1.type < 0) {
                    return h2.height - h1.height;
                } else {
                    return h1.height - h2.height;
                }
            }
            return h1.type - h2.type;
        });

        List<List<Integer>> res = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>((k1, k2) -> k2 - k1);
        map.put(0, 1);

        int prev = 0;
        for (Height h : heights) {
            if (h.type < 0) {
                int count = map.getOrDefault(h.height, 0) + 1;
                map.put(h.height, count);
            } else {
                int count = map.get(h.height) - 1;
                if (count == 0) {
                    map.remove(h.height);
                } else {
                    map.put(h.height, count);
                }
            }
            int cur = map.firstKey();
            if (cur != prev) {
                res.add(Arrays.asList(h.pos, cur));
            }
            prev = cur;
        }
        return res;
    }

    class Height {
        int pos;
        int height;
        int type;
        public Height(int p, int h, int t) {
            pos = p;
            height = h;
            type = t;
        }
    }
}
