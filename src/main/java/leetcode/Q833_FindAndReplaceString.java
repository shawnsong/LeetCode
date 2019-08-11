package leetcode;

import java.util.*;

public class Q833_FindAndReplaceString {
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        int len = indexes.length;
        Replace[] arr = new Replace[len];
        for (int i = 0; i < len; i++) {
            arr[i] = new Replace(indexes[i], sources[i], targets[i]);
        }
        Arrays.sort(arr, (r1, r2) -> r1.idx - r2.idx);
        StringBuilder sb = new StringBuilder();
        int pos = 0;

        for (int i = 0; i < S.length(); i++) {
            if (pos < len && i == arr[pos].idx) {
                if (hasSubstring(S, i, arr[pos].source)) {
                    sb.append(arr[pos].target);
                    i = i + arr[pos].source.length() - 1;
                } else {
                    sb.append(S.charAt(i));
                }
                pos++;
            } else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }

    boolean hasSubstring(String str, int idx, String sub) {
        if (idx + sub.length() > str.length()) return false;
        for (int i = 0;  i < sub.length(); i++) {
            if (str.charAt(idx + i) != sub.charAt(i)) return false;
        }
        return true;
    }

    class Replace {
        int idx;
        String source;
        String target;
        public Replace(int i, String s, String t) {
            idx = i;
            source = s;
            target = t;
        }
    }
}