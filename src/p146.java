import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengwliu on 11/26/17
 * 146. LRU Cache
 */
public class p146 {
    class Node {
        int key, val;
        Node next, prev;
        Node() {
            key = val = 0; next = prev = null;
        }
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            next = null;
            prev = null;
        }
    }
    Node head, tail;
    int capacity;
    int size;
    Map<Integer, Node> map;
    public p146(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        int val = map.get(key).val;
        addToHead(remove(map.get(key)));
        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            map.remove(key);
            size--;
        }
        if (size == capacity){
            Node deleted = remove(tail.prev);
            map.remove(deleted.key);
            size--;
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addToHead(newNode);
        size++;

    }

    private Node remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;

        node.next = null;
        node.prev = null;
        return node;
    }

    private void addToHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.prev = head;
        node.next = next;
        next.prev = node;
    }

    public static void main(String[] args) {
        p146 sol = new p146(2);
        sol.put(1,1);
        sol.put(2,2);
        sol.get(1);
        sol.put(3,3);
        sol.get(2);
        sol.put(4,4);
        sol.get(1);
        sol.get(3);
        sol.get(4);
    }
}
