package month11.day04;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/11/4 14:19
 */
public class demo {
    public int findMaximumXOR(int[] nums) {
//        整体解题思路就是从高位到低位挨个位置假设当前当前位置存在两个数字异或可以为1，然后判断是否成立，如果成立的话那么结果中当前位置就是1
//        然后下次判断下一个位置时，要带上前面已经判断过的所有位置，也就是判断是否存在两个位置异或得到上一次的结果的前提下当前位置也为1。
//         例如：前面存在两个数字异或为101， 那么下一位置就判断是否存在两个数字异或可以为1011 。 因为异或结果最大要保证前面都是1
        int res = 0, mask = 0;
//        因为数组中的数字最大二进制为31位，所以只需要循环31次即可，从高位至低位
        for (int i = 30; i >= 0; i--) {
//            掩码，就是前几位全为1，后几位全为0，然后让数组中的数字与之进行与操作，来截取数组中数字的前几位的二进制.这里的前几位的分割线就是我们遍历到的高位位置
            mask = mask | (1 << i);
//            set集合用来存储在当前位置数组中所有数字的前缀二进制
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
//                这里用与操作，因为前缀和只保留前几位，后面全部置为0，而我们的掩码前几位都为1，后几位都为0，所以进行与操作。你是0与1 进行与就是0 是1就是1 保留原书
                set.add(num & mask);
            }
//            假设当前位置可以为1
            int temp = res | (1 << i);
            for (Integer pre : set) {
//                如果存在前缀 pre 与 我们假设当前位为1 的temp 进行异或的数值的话，代表当前位置是存在两个数字异或得到1的，因为pre ^ temp = x 等价于 pre ^ x = temp
//                其中pre 和 x 都是数组中遍历存在的前缀和
                if (set.contains(pre ^ temp)) {
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }
}

