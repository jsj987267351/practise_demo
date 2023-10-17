package month10.day17;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.ResultTreeType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/10/17 11:48
 */
public class demo2 {
    class LRUCache {
        Map<Integer, MyNode> map;

        class MyNode {
            int key;
            int value;
            MyNode next;
            MyNode pre;

            public MyNode() {
            }

            public MyNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        int CurSize;
        int MaxSize;
        MyNode head;
        MyNode tail;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            head = new MyNode();
            tail = new MyNode();
            head.next = tail;
            tail.pre = head;
            CurSize = 0;
            MaxSize = capacity;
        }

        public int get(int key) {
            MyNode result = map.get(key);
            if (result == null) {
                return -1;
            }
            removeNode(result);
            addNodeToHead(result);
            return result.value;
        }

        public void put(int key, int value) {
            MyNode node = map.get(key);
            if (node != null) {
                node.value = value;
                removeNode(node);
                addNodeToHead(node);
                map.put(key, node);
                return;
            }
            MyNode newNode = new MyNode(key, value);
            if (CurSize == MaxSize) {
                int removedKey = removeLastNode();
                map.remove(removedKey);
            } else {
                CurSize++;
            }
            addNodeToHead(newNode);
            map.put(key, newNode);

        }

        private int removeLastNode() {
            MyNode removed = tail.pre;
            removed.pre.next = removed.next;
            removed.next.pre = removed.pre;
            return removed.key;
        }

        private void addNodeToHead(MyNode node) {
            node.next = head.next;
            head.next = node;
            node.pre = head;
            node.next.pre = node;
        }

        private void removeNode(MyNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
    }
}

