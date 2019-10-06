package leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * Implement a SnapshotArray that supports the following interface:
 * SnapshotArray(int length) initializes an array-like data structure with the given length.  Initially, each element equals 0.
 * void set(index, val) sets the element at the given index to be equal to val.
 * int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
 * int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
 */
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
