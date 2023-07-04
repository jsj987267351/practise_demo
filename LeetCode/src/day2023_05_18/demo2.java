package day2023_05_18;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * <p>
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * <p>
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/5/18 15:05
 */
public class demo2 {
    public int jump(int[] nums) {
//        跳的总步数
        int sum = 0;
//        当前覆盖范围
        int cover = 0;
//        最大覆盖范围
        int maxCover = 0;
//        遍历不需要遍历到最后一个节点
        for (int i = 0; i < nums.length - 1; i++) {
//            找到最大覆盖范围
            maxCover = Math.max(maxCover, i + nums[i]);
//            如果已经到了当前覆盖范围，因为循环没有循环到最后一个节点的原因，所以当前一定是没有跳到终点的
//            所以只需要跳一步，然后将最大覆盖范围赋给当前覆盖范围
//            不用管跳到哪，一定是跳在当前覆盖范围之内
            if (i == cover) {
                sum++;
                cover = maxCover;
            }
        }
        return sum;
    }
}

