package day2023_05_11;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * https://leetcode.cn/problems/jump-game/
 * @date 2023/5/11 15:56
 */
public class demo2 {
    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
//        覆盖范围
        int cover = 0;
            for (int i = 0; i <= cover; i++) {
//                cover改变时，for循环里也会改变，所以不需要用while循环
                cover = Math.max(cover, i + nums[i]);
                if (cover >= nums.length - 1)
                    return true;
            }
        return false;
    }

    public static void main(String[] args) {
         int[] a  = {2,3,1,1,4};
        boolean b = canJump(a);
        System.out.println(b);
    }
}

