package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q857_MinimumCostToHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        Worker[] workers = new Worker[wage.length];
        for (int i = 0; i < wage.length; i++) {
            workers[i] = new Worker(i, (double)wage[i] / (double)quality[i], quality[i]);
        }

        Arrays.sort(workers, Comparator.comparingDouble(w -> w.cost));
        double sum = 0;
        double min = Double.MAX_VALUE;
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int i = 0; i < workers.length; i++) {
            sum += workers[i].quality;
            if (i == k - 1) {
                min = sum * workers[i].cost;
            }
            else if (i >= k) {
                int q = pq.poll();
                sum -= q;
                min = Math.min(sum * workers[i].cost, min);
            }
            pq.add(workers[i].quality);
        }
        return min;
    }

    class Worker {
        int worker;
        double cost;
        int quality;
        Worker(int w, double c, int q) {
            worker = w;
            cost = c;
            quality = q;
        }
    }
}
