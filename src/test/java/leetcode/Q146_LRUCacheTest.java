package leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Q146_LRUCacheTest {

    Q146_LRUCache cache;

    /**
     * ["LRUCache","put","put","get","put","get","put","get","get","get"]
     * [  [2],    [1,1], [2,2], [1], [3,3], [2], [4,4], [1], [3],  [4]]
     *    [null,  null,  null,   1,  null,  -1,   null, -1,   3,   4]
     */
    @Test
    void test() {
        cache = new Q146_LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));;
        cache.put(3,3);
        System.out.println(cache.get(2));
        System.out.println(cache);
    }
}