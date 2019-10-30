package leetcode;

public class Q394_DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;

        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
            } else if (c == '[') {
                int start = i;
                int left = 0;
                while (i < s.length()) {
                    if (s.charAt(i) == '[') {
                        left++;
                    }
                    if (s.charAt(i) == ']') {
                        left--;
                    }
                    if (left == 0) {
                        break;
                    }
                    i++;
                }
                String sub = s.substring(start + 1, i);
                String subRes = decodeString(sub);
                for (int j = 0; j < num; j++) {
                    sb.append(subRes);
                }
                num = 0;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
