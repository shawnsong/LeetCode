package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q281_ZigzagIterator {

    int index;
    int totalSize;
    List<Iterator<Integer>> list;

    public Q281_ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        index = 0;
        totalSize = v1.size() + v2.size();
        list = new ArrayList<>();
        if (v1 != null && v1.size() > 0) {
            list.add(v1.iterator());
        }
        if (v2 != null && v2.size() > 0) {
            list.add(v2.iterator());
        }
    }

    public int next() {
        int pos = index % list.size();
        int res = list.get(pos).next();
        if (!list.get(pos).hasNext()) {
            list.remove(pos);
        } else {
            index++;
        }
        return res;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}