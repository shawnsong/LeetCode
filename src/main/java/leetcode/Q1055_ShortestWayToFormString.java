package leetcode;

import java.util.ArrayList;

public class Q1055_ShortestWayToFormString {
    public int shortestWay(String source, String target) {
        int t = 0;
        int res = 0;
        while (t < target.length()) {
            int start = t;
            for (char c : source.toCharArray()) {
                if (t < target.length() && target.charAt(t) == c) {
                    t++;
                }
            }
            if (t == start) {
                return -1;
            }
            res++;
        }
        return res;
    }

    public int shortestWay2(String source, String target) {
        ArrayList<Integer>[] map = new ArrayList[256];
        for (int i = 0; i < 256; i++) {
            map[i] = new ArrayList();
        }
        for (int i = 0; i < source.length(); i++) {
            map[source.charAt(i)].add(i);
        }
        int res = 1;
        int prev = -1;

        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            if (map[c].size() == 0) {
                return -1;
            }

            int pos = search(map[c], prev + 1);
            if (pos == map[c].size()) {
                res++;
                prev = -1;
                i--;
                continue;
            }
            prev = map[c].get(pos);
        }
        return res;
    }

    int search(ArrayList<Integer> index, int target) {
        int low = 0, high = index.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (index.get(mid) == target) {
                return mid;
            } else if (index.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
