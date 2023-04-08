package day19;

import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/

 * @date 2023/4/8 16:23
 */
public class demo2 {
    class CQueue {
        LinkedList<Integer> s1;
        LinkedList<Integer> s2;
        public CQueue() {
             s1 = new LinkedList<>();
             s2 = new LinkedList<>();
        }
        public void appendTail(int value) {
            s1.push(value);
        }

        public int deleteHead() {
            if (s1.isEmpty() && s2.isEmpty()){
                return -1;
            }
            if (!s2.isEmpty()){
                return s2.poll();
            }
            while (!s1.isEmpty()){
                s2.push(s1.poll());
            }
            return s2.poll();
        }
    }
}

