package leetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q251_Flatten2DVector {

    int cur = 0;
    ArrayList<Iterator<Integer>> itrList;
    public Q251_Flatten2DVector(List<List<Integer>> vec2d) {
        itrList = new ArrayList<>();
        for (List<Integer> l : vec2d) {
            if (l.size() > 0) {
                itrList.add(l.iterator());
            }
        }
    }

    public int next() {
        int res = itrList.get(cur).next();
        if (!itrList.get(cur).hasNext()) {
            cur++;
        }
        return res;
    }

    public boolean hasNext() {
        if (cur == itrList.size()) {
            return false;
        }
        return true;
    }
}
