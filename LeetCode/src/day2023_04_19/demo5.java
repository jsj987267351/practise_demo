package day2023_04_19;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * https://leetcode.cn/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/
 * @date 2023/4/19 17:06
 */
public class demo5 {
    public int majorityElement(int[] nums) {
        int winner = nums[0];
        int sum = 1;
        for (int i = 1; i <nums.length ; i++) {
            if (nums[i] == winner){
                sum++;
            }else if (sum ==0){
                winner = nums[i];
            }else {
                sum--;
            }
        }
        return winner;
    }
}

