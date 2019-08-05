package leetcode;

import java.util.*;

public class Q943_TravellingSalesMan {
    public int minCost(int[][] distance) {
        Map<Vertex, Integer> minCostDp = new HashMap<>();
        Map<Vertex, Integer> parentMap = new HashMap<>();
        List<Set<Integer>> allSets = new LinkedList<>();

        int[] nums = new int[] {distance.length};
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        for (int i = 0; i <= distance.length - 1; i++) {
            subsets(nums, 0, i, new HashSet<>(), allSets);
        }

        for (Set<Integer> set : allSets) {
            for (int currentVertex = 1; currentVertex < distance.length; currentVertex++) {
                if (set.contains(currentVertex)) {
                    continue;
                }
                Vertex vertex = new Vertex(currentVertex, set);
                int minCost = Integer.MAX_VALUE;
                int minCostPrevVertex = 0;
                Set<Integer> copySet = new HashSet<>(set);
                for (int prevVertex : set) {
                    int cost = distance[prevVertex][currentVertex] + getMinCost(copySet, prevVertex, minCostDp);
                    if (cost < minCost) {
                        minCost = cost;
                        minCostPrevVertex = prevVertex;
                    }
                }
                if (set.size() == 0) {
                    minCost = distance[0][currentVertex];
                }
                minCostDp.put(vertex, minCost);
                parentMap.put(vertex, minCostPrevVertex);
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < distance.length; i++) {
            set.add(i);
        }
        int min = Integer.MAX_VALUE;
        int prevVertex = -1;
        Set<Integer> copySet = new HashSet<>(set);
        for (int k : set) {
            int cost = distance[k][0] + getMinCost(set, k, minCostDp);
            if (cost < min) {
                cost = min;
                prevVertex = k;
            }
        }
        parentMap.put(new Vertex(0, set), prevVertex);
        return min;
    }

    int getMinCost(Set<Integer> set, int prevVertex, Map<Vertex, Integer> minCostDp) {
        set.remove(prevVertex);
        Vertex vertex = new Vertex(prevVertex, set);
        int cost = minCostDp.get(vertex);
        set.add(prevVertex);
        return cost;
    }

    void subsets(int[] nums, int startIdx, int size, Set<Integer> solution, List<Set<Integer>> res) {
        if (solution.size() == size) {
            res.add(solution);
            return;
        }

        for(int i = startIdx; i < nums.length; i++) {
            solution.add(nums[i]);
            subsets(nums, i + 1, size, solution, res);
            solution.remove(nums[i]);
        }
    }

    class Vertex {
        int vertex;
        Set<Integer> vertexSet;

        public Vertex(int v, Set<Integer> set) {
            vertex = v;
            vertexSet = set;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Vertex)) {
                return false;
            }
            Vertex v = (Vertex) o;
            if(v.vertex != this.vertex) {
                return false;
            }
            return this.vertexSet == null ? (v.vertexSet == null) : this.vertexSet.equals(v.vertexSet);
        }
    }
}
