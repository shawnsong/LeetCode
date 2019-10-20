package leetcode;

import java.util.ArrayList;

public class Q392_IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        ArrayList<Integer>[] idx = new ArrayList[256];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (idx[c] == null) {
                idx[c] = new ArrayList();
            }
            idx[c].add(i);
        }

        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (idx[c] == null) return false;
            int pos = search(idx[c], prev + 1);
            if (pos == -1 || pos == idx[c].size()) return false;
            prev = idx[c].get(pos);
        }
        return true;
    }

    int search(ArrayList<Integer> list, int target) {
        int low = 0, high = list.size() - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (list.get(mid) == target) {
                return mid;
            } else if (list.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
