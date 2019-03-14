package leetcode;

import java.util.LinkedList;
import java.util.List;

public class Q271_EncodeandDecodeStrings {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str.length()).append("|").append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < str.length();) {
            int sepIdx = str.indexOf("|", i);
            int length = Integer.parseInt(str.substring(i, sepIdx));
            res.add(str.substring(sepIdx + 1, sepIdx + length + 1));
            i = sepIdx + length + 1;
        }
        return res;
    }
}
