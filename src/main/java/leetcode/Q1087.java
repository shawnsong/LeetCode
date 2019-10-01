package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q1087 {
    public String[] expand(String s) {
        List<String> res = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        if (s == null || s.length() == 0) {
            return new String[] {""};
        }
        if (s.charAt(0) == '{') {
            int leftCount = 0;
            int i = 0;
            while (i < s.length()) {
                if (s.charAt(i) == '{') {
                    leftCount++;
                } else if (s.charAt(i) == '}') {
                    leftCount--;
                }

                if (leftCount == 0) {
                    break;
                }
                i++;
            }
            String[] lefts = expand(s.substring(1, i));
            String[] rights = {""};
            if (i < s.length()) {
                rights = expand(s.substring(i + 1));
            }
            for (String l : lefts) {
                for (String r : rights) {
                    res.add(l + r);
                }
            }
        } else {
            int i = 0;
            while (i < s.length() && s.charAt(i) != '{') {
                sb.append(s.charAt(i));
                i++;
            }
            if (i < s.length()) {
                String[] rights = expand(s.substring(i));
                for (String r : rights) {
                    res.add(sb.toString() + r);
                }
            } else {
                res.add(sb.toString());
            }
        }
        String[] ret = new String[res.size()];
        int i = 0;
        for (String str : res) {
            ret[i] = str;
            i++;
        }
        return ret;
    }

}
