package leetcode;

public class Q777 {
    public boolean canTransform(String start, String end) {
        if (start == null || end == null || start.length() != end.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        int len = start.length();
        while (true) {
            while (i < len && start.charAt(i) == 'X') {
                i++;
            }
            while (j < len && end.charAt(j) == 'X') {
                j++;
            }
            if (i == len && j == len) {
                return true;
            } else if (i == len || j == len) {
                return false;
            }
            char c1 = start.charAt(i);
            char c2 = end.charAt(j);
            if (c1 != c2) {
                return false;
            }
            // can only move to left
            if (c1 == 'L' && i < j) {
                return false;
            }
            if (c1 == 'R' && i > j) {
                return false;
            }
            i++;
            j++;
        }
    }
}
