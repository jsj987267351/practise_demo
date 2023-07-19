package month07.day19;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * https://leetcode.cn/problems/qiu-12n-lcof/?envType=study-plan-v2&envId=coding-interviews
 * @date 2023/7/19 15:31
 */
public class demo3 {

    public int sumNums(int n) {
        boolean flag = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }
}

