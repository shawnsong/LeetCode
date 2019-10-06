package leetcode;

import java.util.Map;
import java.util.TreeMap;

public class Q1146_SnapshotArray {
    TreeMap<Integer, Integer>[] arr;
    int snapId;

    public Q1146_SnapshotArray(int length) {
        arr = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new TreeMap<>();
            arr[i].put(0, 0);
        }
        snapId = 0;
    }

    public void set(int index, int val) {
        arr[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        Map.Entry<Integer, Integer> entry = arr[index].floorEntry(snapId);
        return entry.getValue();
    }
}
