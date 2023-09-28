package month09.day28;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/find-closest-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/28 17:14
 */
public class demo2 {
    public int findClosest(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int len = words.length;
//        p,q 分表代表从前往后对应word1 和word2 的下标索引
        for (int i = 0, p = -1, q = -1; i < len; i++) {
            String word = words[i];
            if (word.equals(word1)) p = i;
            if (word.equals(word2)) q = i;
            if (p != -1 && q != -1) {
//                p和q都不等于-1代表两个都已经找到了对应单词，这时就可比较，因为是从前往后每次遍历都判断比较，所以所有可能小的结果都会比较到
//                因为是从前往后遍历的，所以每次取最后遍历到的两个下标比较距离是最小的
                res = Math.min(res, Math.abs(p - q));
//                因为1已经是最小值了，所以可以提前结束遍历
                if (res == 1) return res;
            }
        }
        return res;
    }
}

