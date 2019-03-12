package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q254_FactorCombinations {

    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new LinkedList<>();
        getFactors(n, 2, new ArrayList<>(), res);
        res.remove(res.size() - 1);
        return res;
    }

    private void getFactors(int n, int start, ArrayList<Integer> solution, List<List<Integer>> res) {
        if (n <= 1) {
            if (solution.size() > 0) {
                res.add(new LinkedList<>(solution));
            }
            return;
        }

        for (int i = start; i * i <= n; i++) {
            if (n % i == 0) {
                solution.add(i);
                getFactors(n / i, i, solution, res);
                solution.remove(solution.size() - 1);
            }
        }

        solution.add(n);
        getFactors(1, n, solution, res);
        solution.remove(solution.size() - 1);
    }
}
