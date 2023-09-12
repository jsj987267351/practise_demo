package month09.day11;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/pile-box-lcci/description/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/11 12:18
 */
public class demo {
    public int pileBox(int[][] box) {
        int length = box.length;
        if (length == 0) return 0;
//        首先根据第一维进行升序排列，因为三维都需要递增，所以先控制一维。然后按照后面二维同时满足的情况下求最长递增子序列
        Arrays.sort(box, (a, b) -> a[0] - b[0]);
//        dp[i]：以第i个箱子为结尾时的最高高度,不能直接返回dp数组的最后一维，因为不一定是最大
        int[] dp = new int[length];
        int res = box[0][2];

        for (int i = 0; i < length; i++) {
//       初始值都是自身高度
            dp[i] = box[i][2];
            for (int j = 0; j < i; j++) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + box[i][2]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}

