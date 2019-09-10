package leetcode;

import java.util.TreeSet;

public class Q1087_BraceExpansion {
    public String[] expand(String s) {
        TreeSet<String> set = new TreeSet<>();
        if (s.length() == 0) {
            return new String[] {""};
        }
        if (s.length() == 1) {
            return new String[] {s};
        }
        if (s.charAt(0) == '{') {
            int i = 0;
            while (s.charAt(i) != '}') {
                i++;
            }
            String sub = s.substring(1, i);
            String[] letters = sub.split(",");
            String[] strs = expand(s.substring(i + 1));
            for (String l : letters) {
                for (String str : strs) {
                    set.add(l + str);
                }
            }
        } else {
            String[] strs = expand(s.substring(1));
            for (String str : strs) {
                set.add(s.charAt(0) + str);
            }
        }
        return set.toArray(new String[0]);
    }
}
