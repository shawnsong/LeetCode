package leetcode.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    void test() {
        LRUCache<Integer, Integer> cache = new LRUCache<>(2);
        cache.put(1, 1);
        cache.put(2, 2);
        assertEquals(1, cache.get(1));

        // put 3, evict 2, 3 -> 1
        cache.put(3, 3);
        assertNull(cache.get(2));

        // get 1, 1 -> 3
        assertEquals(1, cache.get(1));
        // put 4 evict 3, 4 -> 1
        cache.put(4,4 );
        assertNull(cache.get(3));
    }
}