package leetcode;


import java.util.HashMap;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class Q146_LRUCache {

    private int size;
    private int capacity;
    private HashMap<Integer, CacheEntry> map;
    private CacheEntry head, tail;


    public Q146_LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        map = new HashMap();
        head = new CacheEntry(0, 0);
        tail = new CacheEntry(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        CacheEntry entry = map.get(key);
        moveToHead(entry);
        return entry.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).value = value;
            return;
        }

        CacheEntry entry = new CacheEntry(key, value);
        map.put(key, entry);
        addEntry(entry);
        size++;
        if (size > capacity) {
            removeTail();
            size--;
        }
    }

    private void moveToHead(CacheEntry entry) {
        removeEntry(entry);
        addEntry(entry);
    }

    private void removeTail() {
        CacheEntry entryToRemove = tail.prev;
        removeEntry(entryToRemove);
        map.remove(entryToRemove.key);
    }

    private void removeEntry(CacheEntry entry) {
        CacheEntry prev = entry.prev;
        CacheEntry next = entry.next;

        prev.next = next;
        next.prev = prev;
    }

    private void addEntry(CacheEntry entry) {
        entry.prev = head;
        entry.next = head.next;

        head.next.prev = entry;
        head.next = entry;
    }
}
class CacheEntry {

    CacheEntry(int key, int val) {
        this.key = key;
        this.value = val;
    }
    int key;
    int value;
    CacheEntry next;
    CacheEntry prev;
}

