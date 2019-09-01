package leetcode;

public class Q394_DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return s;
        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int start = i;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    i++;
                }
                num = Integer.parseInt(s.substring(start, i));
                i--;
            } else if (c == '[') {
                // find ]
                int leftCount = 0;
                int start = i + 1;
                while (i < s.length()) {
                    if (s.charAt(i) == '[') {
                        leftCount++;
                    } else if (s.charAt(i) == ']') {
                        leftCount--;
                    }
                    if (leftCount == 0) {
                        break;
                    }
                    i++;
                }
                String sub = decodeString(s.substring(start, i));
                for (int j = 0; j < num; j++) {
                    sb.append(sub);
                }
                num = 0;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
