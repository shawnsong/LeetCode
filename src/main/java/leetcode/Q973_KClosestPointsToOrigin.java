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
        int left = startIdx + 1, right = endIdx;
        while (left <= right) {
            while (left < endIdx && compare(points[left], pivot) <= 0) {
                left++;
            }
            while (right > startIdx && compare(points[right], pivot) >= 0) {
                right--;
            }
            if (left >= right) break;

            swap(points, left, right);
            left++;
            right--;
        }
        swap(points, startIdx, right);
        return right;
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