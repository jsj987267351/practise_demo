package LeetCode.month07.day03;

import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/7/3 10:24
 */
public class demo6 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        remove(A.size(), A, B, C);
    }

    public void remove(int size, List<Integer> start, List<Integer> sup, List<Integer> target) {
        if (size == 1) {
            target.add(start.remove(start.size() - 1));
            return;
        }
        remove(size - 1, start, target, sup);
        target.add(start.remove(start.size() - 1));
        remove(size - 1, sup, start, target);
    }
}

