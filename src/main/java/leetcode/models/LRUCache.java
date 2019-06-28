package leetcode.models;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    private int capacity;
    private CacheEntry head;
    private CacheEntry tail;
    private Map<K, CacheEntry> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new CacheEntry();
        tail = new CacheEntry();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    public V get(K key) {
        CacheEntry res = map.get(key);
        if(res != null) {
            moveToHead(res);
            return res.val;
        }
        return null;
    }

    public void put(K key, V value) {
        if (map.containsKey(key)) {
            CacheEntry entry = map.get(key);
            entry.val = value;
            moveToHead(entry);
        } else {
            CacheEntry entry = new CacheEntry(key, value);
            map.put(key, entry);
            addToHead(entry);
            if (map.size() > capacity) {
                evict();
            }
        }
    }

    private  void moveToHead(CacheEntry entry) {
        removeFromList(entry);
        addToHead(entry);
    }

    private void removeFromList(CacheEntry entry) {
        CacheEntry prev = entry.prev;
        CacheEntry next = entry.next;
        prev.next = next;
        next.prev = prev;
    }

    private void addToHead(CacheEntry entry) {
        CacheEntry first = head.next;
        head.next = entry;
        entry.prev = head;
        entry.next = first;
        first.prev = entry;
    }

    private void evict() {
        CacheEntry last = tail.prev;
        last.prev.next = tail;
        tail.prev = last.prev;

        map.remove(last.key);
    }

    class CacheEntry {
        CacheEntry prev;
        CacheEntry next;
        K key;
        V val;

        CacheEntry() {
        }

        CacheEntry(K k, V v) {
            key = k;
            val = v;
        }
    }
}
