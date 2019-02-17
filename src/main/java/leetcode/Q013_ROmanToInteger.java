package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q013_ROmanToInteger {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = map.get(s.charAt(0));
        int pre = map.get(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            int cur = map.get(c);

            sum += cur;
            if (pre < cur) {
                sum = sum - pre * 2;
            }
            pre = cur;
        }

        return sum;
    }
}