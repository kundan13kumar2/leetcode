package design.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    static class Node {
        String key;
        int value;
        Node prev;
        Node next;

        public Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static int count;
    static int capacity;
    static Map<String, Node> map;
    static Node head;
    static Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        map = new HashMap<>();
        head = new Node("dummyHead", -1);
        tail = new Node("dummyTail", -1);
    }

    public static void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public static void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public static int get(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            int result = node.value;
            deleteNode(node);
            addToHead(node);
            return result;
        } else return -1;
    }

    public static void put(String key, int val) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = val;
            deleteNode(node);
            addToHead(node);
        } else {
            Node node = new Node(key, val);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }

}
