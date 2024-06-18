package LeetCode.month06.day18;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/6/18 10:50
 */
public class demo6 {
    class LRUCache {

        class MyNode {
            int key;
            int value;
            MyNode pre;
            MyNode next;

            public MyNode() {
            }

            public MyNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        Map<Integer, MyNode> map;
        int curSize;
        int MaxSize;
        MyNode head;
        MyNode tail;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            curSize = 0;
            MaxSize = capacity;
            head = new MyNode();
            tail = new MyNode();
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            MyNode node = map.get(key);
            removeNode(node);
            addToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (!map.containsKey(key)) {
                MyNode node = new MyNode(key, value);
                if (curSize == MaxSize) {
                    int lastKey = removeLast();
                    map.remove(lastKey);
                } else {
                    curSize++;
                }
                addToHead(node);
                map.put(key, node);
            } else {
                MyNode node = map.get(key);
                removeNode(node);
                node.value = value;
                addToHead(node);
                map.put(key, node);
            }
        }

        public void removeNode(MyNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public void addToHead(MyNode node) {
            node.next = head.next;
            head.next = node;
            node.next.pre = node;
            node.pre = head;
        }

        public int removeLast() {
            MyNode removed = tail.pre;
            removed.pre.next = tail;
            tail.pre = removed.pre;
            return removed.key;
        }
    }
}

