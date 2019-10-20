package leetcode;

public class Q248_StrobogrammaticNumberIII {
    char[][] pairs = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};

    public int strobogrammaticInRange(String low, String high) {
        int[] count = new int[1];
        for (int i = low.length(); i <= high.length(); i++) {
            dfs(low, high, new char[i], 0, i - 1, count);
        }
        return count[0];
    }

    private void dfs(String low, String high, char[] arr, int left, int right, int[] count) {
        if (left > right) {
            String s = new String(arr);
            if (arr.length == low.length() && s.compareTo(low) < 0 || arr.length == high.length() && s.compareTo(high) > 0) {
                return;
            }
            count[0]++;
            return;
        }

        for (char[] pair : pairs) {
            arr[left] = pair[0];
            arr[right] = pair[1];

            if (arr.length != 1 && arr[0] == '0') {
                continue;
            }
            if (left == right && pair[0] != pair[1]) {
                continue;
            }
            dfs(low, high, arr, left + 1, right - 1, count);
        }
    }
}
