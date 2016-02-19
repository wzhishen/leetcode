package solutions;

import java.util.HashMap;

/**
 * https://leetcode.com/problems/lru-cache/
 *
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and set.
 * get(key) - Get the value (will always be positive) of the key if the key
 * exists in the cache, otherwise return -1.
 * set(key, value) - Set or insert the value if the key is not already present.
 * When the cache reached its capacity, it should invalidate the least recently
 * used item before inserting a new item.
 */
public class LRUCache_146 {

    public class LRUCache {
        private int capacity;
        private HashMap<Integer, Node> map;
        private Node head;
        private Node tail;
        private class Node {
            int key;
            int val;
            Node next;
            Node prev;
            public Node(int k, int v) {
                key = k;
                val = v;
            }
        }

        public LRUCache(int c) {
            capacity = c;
            map = new HashMap<Integer, Node>();
            head = tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) return -1;
            Node n = map.get(key);
            // extract current node
            n.prev.next = n.next;
            n.next.prev = n.prev;
            // move current node to head
            addToHead(n);
            return n.val;
        }

        public void set(int key, int value) {
            // update existing node
            if (get(key) != -1) {
                map.get(key).val = value;
            // insert new node
            } else {
                Node n = new Node(key, value);
                addToHead(n);
                map.put(key, n);
                // remove last node if full
                if (map.size() > capacity) {
                    map.remove(tail.prev.key);
                    tail.prev = tail.prev.prev;
                    tail.prev.next = tail;
                }
            }
        }

        private void addToHead(Node n) {
            n.next = head.next;
            head.next = n;
            n.next.prev = n;
            n.prev = head;
        }
    }
}
