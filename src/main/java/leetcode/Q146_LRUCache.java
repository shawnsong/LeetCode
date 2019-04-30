package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class Q146_LRUCache {

    int size;
    int capacity;
    CacheEntry head;
    CacheEntry tail;

    Map<Integer, CacheEntry> map;
    public Q146_LRUCache(int capacity) {
        size = 0;
        this.capacity = capacity;
        head = new CacheEntry(0, 0);
        tail = new CacheEntry(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public int get(int key) {
        CacheEntry res = map.get(key);
        if (res == null)
            return 0;

        moveToHead(res);
        return res.value;
    }

    public void put(int key, int value) {
        CacheEntry entry = map.get(key);
        if (entry != null) {
            entry.value = value;
            moveToHead(entry);
        } else {
            entry = new CacheEntry(key, value);
            addEntry(entry);
            size++;
            if (size > capacity) {
                removeFromTail();
            }
            map.put(key, entry);
        }
    }

    private void moveToHead(CacheEntry entry) {
        removeEntry(entry);
        addEntry(entry);
    }

    private void removeEntry(CacheEntry entry) {
        CacheEntry prev = entry.prev;
        CacheEntry next = entry.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addEntry(CacheEntry entry) {
        CacheEntry oldHead = head.next;
        entry.next = oldHead;
        oldHead.prev = entry;

        entry.prev = head;
        head.next = entry;
    }

    private void removeFromTail() {
        CacheEntry toRemove = tail.prev;

        toRemove.prev.next = tail;
        tail.prev = toRemove.prev;
    }

    class CacheEntry {
        int key;
        int value;
        CacheEntry prev;
        CacheEntry next;

        public CacheEntry(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }
}

