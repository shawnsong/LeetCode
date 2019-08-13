package leetcode.models;

public class BinaryIndexTree {

    int[] buildTree(int input[]) {
        int tree[] = new int[input.length + 1];
        for (int i = 1; i <= input.length; i++) {
            updateTree(tree, input[i - 1], i);
        }
        return tree;
    }

    void updateTree(int[] tree, int val, int idx) {
        while (idx < tree.length) {
            tree[idx] += val;
            idx = getNextIndex(idx);
        }
    }

    int getNextIndex(int idx) {
        // get 2's complement
        // and this number
        // add this to the original number
        return idx + (idx & -idx);
    }

    int getParent(int idx) {
        return idx - (idx & -idx);
    }

    int getSum(int[] tree, int idx) {
        idx = idx + 1;
        int sum = 0;
        while (idx > 0) {
            sum += tree[idx];
            idx = getParent(idx);
        }
        return sum;
    }
}
