package zjc.Study01.hashmap;

import java.util.HashMap;

public class Hashmap {
    static class LRUCache {
        int capacity;
        HashMap<Integer,Node> map;
        Node head;
        Node tail;
        class Node{
            int key;
            int data;
            Node prev;
            Node next;
            public Node(int key,int data){
                this.key = key;
                this.data = data;
            }
        }

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.head = new Node(-1,-1);
            this.tail = new Node(-1,-1);

            this.head.next = this.tail;
            this.tail.prev = this.head;

        }

        public int get(int key) {
            Node currentNode = this.map.get(key);
            if(currentNode == null){
                return -1;
            }
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
            currentNode.next = this.head.next;
            this.head.next.prev = currentNode;
            this.head.next = currentNode;
            currentNode.prev = this.head;
            return currentNode.data;
        }

        public void put(int key, int value) {
            Node currentNode = this.map.get(key);
            /// 先判断是否在hash表中有这个key
            if(currentNode != null){
                currentNode.data = value;
                currentNode.prev.next = currentNode.next;
                currentNode.next.prev = currentNode.prev;
                currentNode.next = this.head.next;
                this.head.next.prev = currentNode;
                this.head.next = currentNode;
                currentNode.prev = this.head;
                return;
            }
            // 判断capacity大小是否超了
            Node readyEleteNode = this.tail.prev;
            if(this.map.size()>=this.capacity){
                this.map.remove(readyEleteNode.key);
                readyEleteNode.prev.next = this.tail;
                this.tail.prev = readyEleteNode.prev;
            }
            Node addNode = new Node(key,value);
            this.map.put(key,addNode);
            addNode.next = this.head.next;
            addNode.prev = this.head;
            this.head.next.prev = addNode;
            this.head.next = addNode;
        }


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
