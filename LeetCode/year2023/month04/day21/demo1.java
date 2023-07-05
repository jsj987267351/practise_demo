package month04.day21;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」 定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false

 * 链接：https://leetcode.cn/problems/happy-number
 * @date 2023/4/21 13:22
 */
public class demo1 {
    public boolean isHappy1(int n) {
        Set<Integer> set = new HashSet<>();
        while (n !=1 && !set.contains(n)){
            set.add(n);
            n = getNext(n);
        }
        return n ==1;
    }

    public int getNext(int n){
        int sum = 0;
        while (n>0){
            int temp = n %10;
            n  = n/10;
            sum += temp *temp;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int slow = n;
        int fast = getNext(n);
        while (slow!=fast && fast!=1){
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast ==1;
    }
}

