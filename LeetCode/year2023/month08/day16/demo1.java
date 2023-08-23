package month08.day16;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/find-the-losers-of-the-circular-game/description/
 * @date 2023/8/16 15:13
 */
public class demo1 {
    public int[] circularGameLosers(int n, int k) {
//        代表每个学生是否接触过球，接触过为true，初始都为false
        boolean[] visited = new boolean[n];
//        这里i代表每个学生，j代表下一次需要移动的距离,当一个学生第二低接球时停止，也就是当遍历到这个学生为true时，代表他已经接触过一次球了，即游戏停止
        for (int i = 0, j = k; !visited[i]; j += k) {
//            该学生第一次接触球，设置为true
            visited[i] = true;
//            传给的下一个学生的位置，因为循环，所以取余
            i = (i + j) % n;
        }

//        此时visited中为false的就是没接触过球的
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
//                因为学生从1开始计数
                list.add(i + 1);
            }
        }
//        此时list中存储的就是结果
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }

        return res;
    }
}

