package leetcode;

public class Q839 {
    public int numSimilarGroups(String[] words) {
        int n = words.length;
        int[] roots = new int[n];
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isSimilar(words[i], words[j])) {
                    int x = findRoot(roots, i);
                    int y = findRoot(roots, j);
                    if (x != y) {
                        roots[x] = y;
                        n--;
                    }
                }
            }
        }
        return n;
    }

    int findRoot(int[] roots, int node) {
        while (roots[node] != node) {
            roots[node] = roots[roots[node]];
            node = roots[node];
        }
        return node;
    }

    boolean isSimilar(String w1, String w2) {
        int count = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
