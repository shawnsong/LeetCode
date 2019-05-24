package leetcode;

import java.util.ArrayList;

public class Q451_SortCharactersByFrequency {
    public String frequencySort(String str) {
        int[] map = new int[256];
        for (char c : str.toCharArray()) {
            map[c]++;
        }

        ArrayList<Character>[] buckets = new ArrayList[str.length() + 1];
        for (int i = 0; i < 256; i++) {
            if (map[i] != 0) {
                int count = map[i];
                if (buckets[count] == null) {
                    buckets[count] = new ArrayList<>();
                }
                buckets[count].add((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }
}
