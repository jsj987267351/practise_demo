package day71;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * <p>
 * 你需要按照以下要求，给这些孩子分发糖果：
 * <p>
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/candy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/27 13:48
 */
public class demo3 {
    public int candy(int[] ratings) {
        int length = ratings.length;
//        最终集合对应下标满足的糖果数
        int[] candy = new int[length];
        candy[0] = 1;
//        先只考虑右边比左边大的情况，初始开头为1
        for (int i = 1; i < length; i++) {
//            如果右边比左边大的话，就要在左边糖果的基础上+1，否则就是默认的1
            candy[i] = ratings[i] > ratings[i - 1] ? candy[i - 1] + 1 : 1;
        }
//      在考虑左边比右边大的情况，利用上边的结果，从右向左遍历
        for (int i = length - 2; i >= 0; i--) {
//            如果左边比右边大，因为要左右都满足，所以取左边满足和右边满足的最大值
//            举例： 1 3 4 5 2
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }

        int sum = 0;
        for (int num : candy) {
            sum += num;
        }
        return sum;
    }
}

