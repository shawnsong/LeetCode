package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Q710_RandomPickWithBlacklist {
    Map<Integer, Integer> map = new HashMap<>();
    private int size;
    private Random rand;

    public Q710_RandomPickWithBlacklist(int n, int[] blacklist) {
        size = n - blacklist.length;
        for (int b : blacklist) {
            map.put(b, -1);
        }
        n--;
        for (int b : blacklist) {
            if (b <= size) {
                while (map.containsKey(n)) {
                    n--;
                }
                map.put(b, n);
                n--;
            }
        }
        rand = new Random();
    }
    public int pick() {
        int num = rand.nextInt(size);
        if (map.containsKey(num)) {
            return map.get(num);
        }
        return num;
    }
}
