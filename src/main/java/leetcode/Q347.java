package leetcode;

import java.util.*;

public class Q347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new LinkedList<>();

        Map<Integer, Set<Integer>> map = new HashMap<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;

        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0) + 1;
            maxFreq = Math.max(maxFreq, freq);

            map.putIfAbsent(freq, new HashSet());
            map.get(freq).add(num);
            if (freq > 1) {
                map.get(freq - 1).remove(num);
            }
        }

        while (res.size() < k) {
            res.addAll(map.get(maxFreq));
            maxFreq--;
        }
        return res;
    }
}
