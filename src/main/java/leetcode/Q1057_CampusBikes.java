package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. Each worker and bike is a 2D coordinate on this grid.
 *
 * Our goal is to assign a bike to each worker. Among the available bikes and workers, we choose the (worker, bike) pair with the shortest
 * Manhattan distance between each other, and assign the bike to that worker.
 *
 * If there are multiple (worker, bike) pairs with the same shortest Manhattan distance, we choose the pair with the smallest worker index;
 * if there are multiple ways to do that, we choose the pair with the smallest bike index.
 *
 * We repeat this process until there are no available workers.
 *
 * The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
 *
 * Return a vector ans of length N, where ans[i] is the index (0-indexed) of the bike that the i-th worker is assigned to.
 */
public class Q1057_CampusBikes {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        if (workers == null || bikes == null) {
            return new int[0];
        }

        PriorityQueue<WorkerBike> pq = new PriorityQueue<>((w1, w2) -> {
            if (w1.dist != w2.dist) {
                return w1.dist - w2.dist;
            } else if (w1.worker != w2.worker) {
                return w1.worker - w2.worker;
            }
            return w1.bike - w2.bike;
        });

        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                pq.add(new WorkerBike(i, j, dist(workers[i], bikes[j])));
            }
        }

        int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        boolean[] used = new boolean[bikes.length];
        int count = 0;
        while (count < workers.length) {
            WorkerBike wb = pq.poll();
            if (res[wb.worker] == -1 && !used[wb.bike]) {
                res[wb.worker] = wb.bike;
                used[wb.bike] = true;
                count++;
            }
        }
        return res;
    }

    int dist(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }

    class WorkerBike {
        int worker;
        int bike;
        int dist;
        public WorkerBike(int w, int b, int d) {
            worker = w;
            bike = b;
            dist = d;
        }
    }
}
