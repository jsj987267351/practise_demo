package month10.day25;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/find-the-punishment-number-of-an-integer/description/?envType=daily-question&envId=2023-10-25
 * @date 2023/10/25 15:50
 */
public class demo1 {

    //    可以先对1000个数字进行预处理
    private final static int[] Fn = new int[1001];

    static {
        for (int i = 1; i < 1001; i++) {
            Fn[i] = Fn[i - 1] + (isPublishNumber(String.valueOf(i * i), i, 0) ? i * i : 0);
        }
    }

    public int punishmentNumber(int n) {
        return Fn[n];
    }

    //    该方法作用为：对于字符串s，从startIndex 开始往后分割，能否分割成和为 target
    public static boolean isPublishNumber(String s, int target, int startIndex) {
//        终止条件,如果 target 小于0 肯定直接返回false，后续不可能分割和为 负数
        if (target < 0) {
            return false;
        } else if (target == 0 && startIndex == s.length()) {
//            分割成功的情况，字符串完全分割完，并且总和正好为 target
            return true;
        } else {
//            开始分割
            for (int i = startIndex; i < s.length(); i++) {
//                当前分割出来的数字
                int curNum = Integer.parseInt(s.substring(startIndex, i + 1));
//                递归，首先 target 剩余的数字一定要比当前分割出来的数字大，然后递归后续分割能否分割成 target减去当前分割后剩余的数字
//                如果不能的话，那么条件就会不满足，就会回溯到当前位置继续下一次位置的分割
                if (target >= curNum && isPublishNumber(s, target - curNum, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }


    public int punishmentNumber1(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (isPublishNumber(String.valueOf(i * i), i, 0)) {
                res += i * i;
            }
        }
        return res;
    }
}

