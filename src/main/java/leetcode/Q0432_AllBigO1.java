package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implement a data structure supporting the following operations:
 *
 *     Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 *     Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1.
 *      If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 *     GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 *     GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 */
public class Q0432_AllBigO1 {
  Bucket head;
  Bucket tail;
  Map<String, Integer> keyCountMap;
  Map<Integer, Bucket> countBucketMap;

  /** Initialize your data structure here. */
  public Q0432_AllBigO1() {
    head = new Bucket(Integer.MIN_VALUE);
    tail = new Bucket(Integer.MAX_VALUE);
    keyCountMap = new HashMap<>();
    countBucketMap = new HashMap<>();
    head.next = tail;
    tail.prev = head;
  }

  /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
  public void inc(String key) {
    if (keyCountMap.containsKey(key)) {
      changeKey(key, 1);
    } else {
      keyCountMap.put(key, 1);
      if (head.next.count != 1) {
        addBucketAfter(new Bucket(1), head);
      }
      head.next.keySet.add(key);
      countBucketMap.put(1, head.next);
    }
  }

  /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
  public void dec(String key) {
    if (keyCountMap.containsKey(key)) {
      int count = keyCountMap.get(key);
      if (count == 1) {
        keyCountMap.remove(key);
        countBucketMap.get(1).keySet.remove(key);
        removeKeyFromBucket(countBucketMap.get(1), key);
      } else {
        changeKey(key, -1);
      }
    }
  }

  /** Returns one of the keys with maximal value. */
  public String getMaxKey() {
    return head.next == tail ? "" : tail.prev.keySet.iterator().next();
  }

  /** Returns one of the keys with Minimal value. */
  public String getMinKey() {
    return head.next == tail ? "" : head.next.keySet.iterator().next();
  }

  void changeKey(String key, int offset) {
    int count = keyCountMap.get(key);
    keyCountMap.put(key, count + offset);

    Bucket oldBucket = countBucketMap.get(count);
    Bucket newBucket;
    if (countBucketMap.containsKey(count + offset)) {
      newBucket = countBucketMap.get(count + offset);
    } else {
      newBucket = new Bucket(count + offset);
      countBucketMap.put(count + offset, newBucket);
      addBucketAfter(newBucket, offset == 1 ? oldBucket : oldBucket.prev);
    }
    newBucket.keySet.add(key);
    removeKeyFromBucket(oldBucket, key);
  }

  void addBucketAfter(Bucket newBucket, Bucket oldBucket) {
    newBucket.prev = oldBucket;
    newBucket.next = oldBucket.next;
    oldBucket.next = newBucket;
    oldBucket.next.prev = newBucket;
  }
  void removeKeyFromBucket(Bucket bucket, String key) {
    bucket.keySet.remove(key);
    if (bucket.keySet.isEmpty()) {
      removeBucketFromList(bucket);
      countBucketMap.remove(bucket.count);
    }
  }
  void removeBucketFromList(Bucket bucket) {
    bucket.prev.next = bucket.next;
    bucket.next.prev = bucket.prev;
  }

  class Bucket {
    Set<String> keySet;
    Bucket prev;
    Bucket next;
    int count;

    Bucket(int count) {
      this.count = count;
      keySet = new HashSet<>();
    }
  }
}
