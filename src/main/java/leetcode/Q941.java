package leetcode;

public class Q941 {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }

        int i = 1;
        for (; i < A.length; i++) {
            if (A[i] == A[i-1]) {
                return false;
            } else if (A[i] < A[i-1]) {
                break;
            }
        }

        if (i == 1 || i == A.length) {
            return false;
        }
        for (; i < A.length; i++) {
            if (A[i] >= A[i-1]) {
                return false;
            }
        }
        return true;
    }
}
