package leetcode;

public class Q973_KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        if (points == null || points.length <= k)
            return points;
        int low = 0, high = points.length - 1;
        while (low <= high) {
            int index = partition(points, low, high);
            if (index == k - 1) {
                break;
            } else if (index > k - 1) {
                high = index - 1;
            } else {
                low = index + 1;
            }
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i][0] = points[i][0];
            res[i][1] = points[i][1];
        }
        return res;
    }

    private int partition(int[][] points, int startIdx, int endIdx) {
        int[] pivot = points[startIdx];
        int pos = startIdx;
        for (int i = startIdx + 1; i <= endIdx; i++) {
            if (distanceSquare(points[i]) <= distanceSquare(pivot)) {
                pos++;
                if (pos != i) {
                    swap(points, i, pos);
                }
            }
        }
        swap(points, startIdx, pos);
        return pos;
    }

    void swap(int[][] arr, int i, int j) {
        int[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    int compare(int[] p1, int[] p2) {
        if (distanceSquare(p1) > distanceSquare(p2)) return 1;
        else if (distanceSquare(p1) < distanceSquare(p2)) return -1;
        else return 0;
    }

    int distanceSquare(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }
}