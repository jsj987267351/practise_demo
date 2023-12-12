package month12.day12;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/12 14:51
 */
public class demo6 {
    public int iceBreakingGame(int num, int target) {
        int res = 0;
//        每次删除的元素放在删除后的队列的最后然后右移m个，将溢出的移到队头就变成了删之前的队列（下标也跟着移动）
//        根据这个规则从删到只剩最后一个元素，下标为0，不断增加元素恢复到初始状态下标就是答案
        for (int i = 2; i <= num; i++) {
            res = (res + target) % i;
        }
        return res;
    }
}

