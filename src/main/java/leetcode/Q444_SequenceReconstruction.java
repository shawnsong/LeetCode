package leetcode;

import java.util.*;

public class Q444_SequenceReconstruction {
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer, Set<Integer>> nexts = new HashMap<>();
        Map<Integer, Integer> indegrees = new HashMap<>();

        for (List<Integer> seq : seqs) {
            int prev = 0;
            for (int i = 0; i < seq.size(); i++) {
                int cur = seq.get(i);
                indegrees.putIfAbsent(cur, 0);
                nexts.putIfAbsent(cur, new HashSet());
                if (i > 0) {
                    if (nexts.get(prev).add(cur)) {
                        indegrees.put(cur, indegrees.get(cur) + 1);
                    }
                }
                prev = cur;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : indegrees.entrySet()) {
            if (entry.getValue() == 0) {
                queue.add(entry.getKey());
            }
        }

        int idx = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size > 1) {
                return false;
            }
            int cur = queue.poll();
            if (idx == org.length || cur != org[idx]) {
                return false;
            }
            idx++;
            for (int next : nexts.get(cur)) {
                indegrees.put(next, indegrees.get(next) - 1);
                if (indegrees.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        return idx == org.length && idx == indegrees.size();
    }
}
