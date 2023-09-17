package month09.day17;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/factorial-zeros-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/17 13:07
 */
public class demo1 {
    public int trailingZeroes(int n) {
//        统计结尾有多少个0，就是统计阶乘中出现了多少个10，每个10都由2*5得来，阶乘从小到大只要出现了5，那么前面一定存在2
//        所以统计出现了多少个5即可，但是5的幂次方会出现多个5，几次幂就会出现几个5，所以还要统计出现了几次5的次幂
//        每次/5，统计数量，第一次统计的是出现的5的次数，第二次是出现25的次数，以此类推。虽然出现25应该算出现2次5，总数应该加2
//        但是前面统计5的数量的时候已经加上了他的一次5，所以每次仍然只需要+1即可
        int res = 0;
        while (n >= 5) {
            n /= 5;
            res += n;
        }
        return res;
    }
}

