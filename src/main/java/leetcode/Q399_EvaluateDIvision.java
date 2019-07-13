package leetcode;

import java.util.*;

public class Q399_EvaluateDIvision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Division>> map = new HashMap<>();

        for (int i = 0; i < values.length; i++) {
            List<String> eq = equations.get(i);
            map.putIfAbsent(eq.get(0), new LinkedList<>());
            map.putIfAbsent(eq.get(1), new LinkedList<>());
            map.get(eq.get(0)).add(new Division(eq.get(1), values[i]));
            map.get(eq.get(1)).add(new Division(eq.get(0), 1.0 / values[i]));
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            double result = dfs(queries.get(i).get(0), queries.get(i).get(1), map, new HashSet<>(), 1.0);
            res[i] = result == 0 ? -1 : result;
        }
        return res;
    }

    private double dfs(String start, String end, Map<String, List<Division>> map, Set<String> visited, double value) {
        if (!map.containsKey(start) || visited.contains(start)) {
            return 0;
        }
        if (start.equals(end)) {
            return value;
        }

        visited.add(start);
        double tmp = 0;
        for (Division div : map.get(start)) {
            tmp = dfs(div.divisor, end, map, visited, value * div.value);
            if (tmp != 0) {
                return tmp;
            }
        }
        visited.remove(start);
        return tmp;
    }

    class Division {
        String divisor;
        double value;
        public Division(String d, double v) {
            divisor = d;
            value = v;
        }
    }
}
