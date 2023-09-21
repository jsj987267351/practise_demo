package month09.day21;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/21 14:07
 */
public class demo4 {
    class LRUCache {
        //         自己定义一个双向链表节点，存储key与value
        class DLinkedNode {
            int key;
            int value;
            DLinkedNode pre;
            DLinkedNode next;

            public DLinkedNode() {
            }

            public DLinkedNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        //            定义头尾节点
        DLinkedNode head;
        DLinkedNode last;
        //            当前链表中的节点数量
        int curSize;
        //            最大容量
        int capacity;
        //        定义map用来查找
        Map<Integer, DLinkedNode> map;

        public LRUCache(int capacity) {
//            初始化，包括首尾链表相连、容量的初始化、hash表初始化
            this.curSize = 0;
            this.capacity = capacity;
            head = new DLinkedNode();
            last = new DLinkedNode();
            head.next = last;
            last.pre = head;
            map = new HashMap<>();
        }

        public int get(int key) {
            DLinkedNode node = map.get(key);
            if (node == null) {
                return -1;
            }
//          如果存在的话，需要返回结果前把该节点移动到头部,移动到头部就是先将该节点从链表中删除，然后添加到头部即可
            removeNode(node);
            addToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
//            首先判断链表中是否存在该节点，如果存在更新后移动到头部即可
            if (map.containsKey(key)) {
//              存在的情况
                DLinkedNode node = map.get(key);
                node.value = value;
                removeNode(node);
                addToHead(node);
                return;
            }
//            走到这说明链表中没有该节点
            DLinkedNode newNode = new DLinkedNode(key, value);
//            先判断容量是否已满
            if (curSize == capacity) {
//                已经满了的话就需要先删除链表尾部元素
                int removedKey = removeLast();
                map.remove(removedKey);
            } else {
//                没满的话需要总容量++，后续处理相同，所以直接拿出去
                curSize++;
            }
//            不管满不满都要将该节点插入到链表中，满与不满的处理前面都处理好了
            map.put(key,newNode);
            addToHead(newNode);
        }

        private int removeLast() {
            DLinkedNode removed = last.pre;
            removed.next.pre = removed.pre;
            removed.pre.next = removed.next;
            return removed.key;
        }

        private void removeNode(DLinkedNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        private void addToHead(DLinkedNode node) {
            node.next = head.next;
            node.next.pre = node;
            head.next = node;
            node.pre = head;
        }
    }
}

