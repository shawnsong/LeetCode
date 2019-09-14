package leetcode;

import java.util.*;

public class Q743_NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            int from = time[0], to = time[1], cost = time[2];
            map.putIfAbsent(from, new LinkedList());
            map.get(from).add(new int[] {to, cost});
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>((i1, i2) -> i1[1] - i2[1]);
        pq.add(new int[] {k, 0});
        boolean[] visited = new boolean[n + 1];
        int count = 0;
        int cost = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int cur = node[0], curCost = node[1];
            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;
            count++;
            if (count == n) {
                return curCost;
            }
            List<int[]> nexts = map.getOrDefault(cur, new LinkedList<>());
            for (int[] next : nexts) {
                if (visited[next[0]]) continue;
                pq.add(new int[] {next[0], curCost + next[1]});
            }
        }
        return cost == Integer.MAX_VALUE ? -1 : cost;
    }
}
