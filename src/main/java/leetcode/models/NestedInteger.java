package leetcode.models;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
    Integer integer;
    List<NestedInteger> list;

    public NestedInteger() {
        integer = null;
        list = new ArrayList<>();
    }

    public NestedInteger(int value) {
        integer = value;
        list = new ArrayList<>();
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public List<NestedInteger> getList() {
        return list;
    }

    public void setList(List<NestedInteger> list) {
        this.list = list;
    }

    public boolean isInteger() {
        return integer != null;
    }
}
