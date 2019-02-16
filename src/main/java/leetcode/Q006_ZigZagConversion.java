package leetcode;

import java.util.Arrays;

public class Q006_ZigZagConversion {

    public String convert(String s, int numRows) {
        if (s == null || numRows < 1) {
            throw new IllegalArgumentException("Wrong input");
        }

        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++)
            sb[i] = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            // top down
            for (int j = 0; j < numRows && i < s.length(); j++) {
                sb[j].append(s.charAt(i));
                i++;
            }
            for (int j = numRows - 2; j > 0 && i < s.length(); j--) {
                sb[j].append(s.charAt(i));
                i++;
            }
        }

        for (i = 1; i < numRows; i++) {
            sb[0].append(sb[i].toString());
        }
        return sb[0].toString();
    }
}
