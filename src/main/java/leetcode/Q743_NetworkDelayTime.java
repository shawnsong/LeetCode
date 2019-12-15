package leetcode;

import java.util.*;

/**
 * There are N network nodes, labelled 1 to N.
 * Given times, a list of travel times as directed edges times[i] = (u, v, w), where u is the source node, v is the target node,
 * and w is the time it takes for a signal to travel from source to target.
 *
 * Now, we send a signal from a certain node K. How long will it take for all nodes to receive the signal? If it is impossible, return -1.
 */
public class Q743_NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] time : times) {
            int from = time[0], to = time[1], cost = time[2];
            map.putIfAbsent(from, new LinkedList());
            map.get(from).add(new int[] {to, cost});
        }


        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
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
        return -1;
    }
}
