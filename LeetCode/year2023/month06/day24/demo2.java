package month06.day24;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/24 15:36
 */
public class demo2 {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() < 4 || s.length() > 12) {
            return res;
        }
        StringBuilder sb = new StringBuilder(s);
        backtracking(sb, 0, 0);
        return res;

    }

    //     pointSum 为。 的数量
    public void backtracking(StringBuilder sb, int startIndex, int pointSum) {
//        结束条件
        if (pointSum == 3) {
//            如果.的数量已经到了3，那么就判断后面的字符串是否符合要求，符合则为最终结果
            if (help(sb, startIndex, sb.length() - 1)) {
                res.add(sb.toString());
            }
//            return写在if外面,不论是否符合都要返回
            return;
        }

        for (int i = startIndex; i < sb.length(); i++) {
//            如果合法的话,就在后面加.，然后继续递归回溯
            if (help(sb, startIndex, i)) {
//                加.
                sb.insert(i + 1, '.');
//                这里i+2的原因是直接修改了原字符串，所以需要+2
                backtracking(sb, i + 2, pointSum + 1);
//                删除.
                sb.deleteCharAt(i + 1);
            }
        }
    }

    //    判断是否符合要求函数
    public boolean help(StringBuilder sb, int start, int end) {
        if (start > end) {
            return false;
        }
//        如果开头为0，且不是单独字符串的话，则不符合
        if (sb.charAt(start) == '0' && start != end) {
            return false;
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            int num = sb.charAt(i) - '0';
//            字符不合法
            if (num < 0 || num > 9) {
                return false;
            }
//            总和判断
            sum = sum * 10 + num;
            if (sum > 255) {
                return false;
            }
        }
        return true;
    }
}

