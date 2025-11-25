package jingdian150;

import java.util.HashMap;
import java.util.Map;

class Node {
    Node next;
    Node pre;
    int val;
    int key;

    public Node(int key,int val) {
        this.val = val;
        this.key=key;
    }
}

public class LRUCache {

    Node head;
    Node last;
    Map<Integer, Node> map;
    int cap;


    public LRUCache(int capacity) {
        head = new Node(0,0);
        last = new Node(0,0);
        map = new HashMap<>();
        head.next = last;
        last.pre = head;
        cap = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);

        if (head.next == node) {
            return key;
        }

        Node next = node.next;
        Node pre = node.pre;
        pre.next=next;
        next.pre=pre;
        Node hNext = head.next;
        head.next=node;
        node.pre=head;
        node.next=hNext;
        hNext.pre=node;
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.val=value;
            get(key);
            return;
        }
        Node node = new Node(key, value);
        map.put(key,node);
        if (cap==0){

            Node next = head.next;
            head.next=node;
            node.pre=head;
            node.next=next;
            next.pre=node;

            Node pre = last.pre.pre;
            Node pre1 = last.pre;
            pre.next=last;
            last.pre=pre;
            map.remove(pre1.key);
            return;
        }
        cap--;
        Node next = head.next;
        head.next=node;
        node.pre=head;
        node.next=next;
        next.pre=node;
    }
}
