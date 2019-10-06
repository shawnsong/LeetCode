package leetcode;

import java.util.*;

public class Q1168_WaterDistributionInVillage {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        PriorityQueue<HouseCost> pq;
        pq = new PriorityQueue<>((h1, h2) -> h1.cost - h2.cost);
        for (int i = 0; i < n; i++) {
            pq.add(new HouseCost(i + 1, wells[i]));
        }

        Map<Integer, List<Pipe>> nexts = new HashMap<>();
        for (int[] pipe : pipes) {
            int from = pipe[0];
            int to = pipe[1];
            int cost = pipe[2];
            nexts.putIfAbsent(from, new LinkedList<>());
            nexts.get(from).add(new Pipe(from, to, cost));
            nexts.putIfAbsent(to, new LinkedList<>());
            nexts.get(to).add(new Pipe(to, from, cost));
        }

        boolean[] visited = new boolean[n + 1];
        int count = 0;
        int cost = 0;
        while (!pq.isEmpty()) {
            HouseCost hc = pq.poll();
            if (visited[hc.house]) {
                continue;
            }
            count++;
            visited[hc.house] = true;
            cost += hc.cost;
            if (count == n) {
                break;
            }
            List<Pipe> next = nexts.getOrDefault(hc.house, new LinkedList());
            for (Pipe p : next) {
                if (visited[p.to]) continue;
                pq.add(new HouseCost(p.to,  p.cost));
            }
        }
        return cost;
    }

    class Pipe {
        int from;
        int to;
        int cost;
        Pipe(int f, int t, int c) {
            from = f;
            to = t;
            cost = c;
        }
    }

    class HouseCost {
        int house;
        int cost;

        HouseCost(int h, int c) {
            house = h;
            cost = c;
        }
    }
}
