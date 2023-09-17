package month09.day17;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/diving-board-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/17 14:08
 */
public class demo4 {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k < 1) {
//            木板数量不足1，无解
            return new int[]{};
        }
        if (shorter == longer) {
//            如果长木板与短木板长度一致的话，那么只有唯一解
            return new int[]{shorter * k};
        }
//        否则的话枚举长木板的数量longNum，那么 k - longNum 就是短木板的数量
//        因为返回的结果需要从小到大排列，为了后续不对数组重新排序，所以我们采用长木板的数量从小到大遍历
//        因为长木板的数量越少，总长度就越小
        int[] res = new int[k + 1];
        for (int longNum = 0; longNum < k+1; longNum++) {
            res[longNum] = longNum * longer + (k - longNum) * shorter;
        }
        return res;
    }
}

