package month09.day09;

import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/9 13:48
 */
public class demo2 {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        help(A.size(), A, B, C);
    }

 //    开始柱子，中间辅助柱子，目标柱子。  该函数用处为将  start 的 size 个盘子移动到 target 柱子上
    public void help(int size, List<Integer> start, List<Integer> sup, List<Integer> target) {
//        递归结束条件，start 只有一个盘子时直接移动到 target 柱子上即可，然后return到上一步继续回执。
        if (size == 1) {
            target.add(start.remove(start.size() - 1));
            return;
        }
//        先将前n-1个盘子移动到中间柱子上,调整参数位置，让 sup 柱子为目标柱子，target作为辅助介质
        help(size - 1, start, target, sup);
//        将剩下的一个盘子移动到target 柱子上
        target.add(start.remove(start.size() - 1));
//        然后将 sup 柱子上的 n-1 个盘子移动到 target 柱子上。
        help(size - 1, sup, start, target);
    }
}

