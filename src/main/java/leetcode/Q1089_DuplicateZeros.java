package leetcode;

public class Q1089_DuplicateZeros {
    public void duplicateZeros(int[] arr) {
        int pos = -1;
        int i = 0;
        for (; i < arr.length; i++) {
            if (arr[i] != 0) {
                pos++;
            } else {
                pos += 2;
            }
            if (pos >= arr.length - 1) {
                break;
            }
        }

        for (; i >= 0; i--) {
            if (pos < arr.length) {
                arr[pos] = arr[i];
            }
            pos--;
            if (arr[i] == 0) {
                arr[pos] = arr[i];
                pos--;
            }
        }
    }
}
