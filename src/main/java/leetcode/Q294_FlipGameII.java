package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Q294_FlipGameII {

    public boolean canWin(String s) {
        return canWin(s.toCharArray(), new HashMap<>());
    }

    private boolean canWin(char[] c, Map<String, Boolean> map) {
        if(map.containsKey(String.valueOf(c))) {
            return map.get(String.valueOf(c));
        }

        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == c[i+1] && c[i] == '+') {
                c[i] = '-';
                c[i+1] = '-';

                boolean opponentWin = canWin(c, map);

                c[i] = c[i+1] = '+';
                // if the opponent loses, then the player wins
                if (!opponentWin) {
                    map.put(String.valueOf(c), true);
                    return true;
                } else {
                    map.put(String.valueOf(c), false);
                }
            }
        }
        return false;
    }
}
