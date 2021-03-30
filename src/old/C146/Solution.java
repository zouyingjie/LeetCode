package old.C146;


import java.util.*;

public class Solution{}

class LRUCache {

    private int capacity;

    private Map<Integer, Integer> map = new HashMap<>();
    private Queue<Integer> queue;

    public LRUCache(int capacity) {

        queue = new LinkedList<Integer>();
        this.capacity = capacity;

    }

    public int get(int key) {

        if(queue.contains(key)) {
            queue.remove(key);
            queue.add(key);
            return map.get(key);
        }


        return -1;

    }

    public void put(int key, int value) {


        if(queue.contains(key)) {
            queue.remove(key);
        }else {
            if (queue.size() == this.capacity) {
                queue.poll();
            }
        }

        queue.add(key);
        map.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);
    }
}
