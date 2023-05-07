package leetcode.medium;

import java.util.*;

// 146. LRU Cache
class LRUCache {

    private final int initCapacity;
    private final Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        initCapacity = capacity;
        // linkedHashMap에서는 내부적으로 accessOrder라는 값을 받아서 접근 빈도에 따라 순서가 변경되도록 할 수 있다.
        // load factor는 해시 테이블의 버킷이 얼마나 가득찼는지 보여주는 값인데 디폴트가 0.75당
        map = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        map.put(key, value);
        if (map.size() > initCapacity) {
            int leastUsedKey = map.keySet().iterator().next();
            map.remove(leastUsedKey);
        }
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
