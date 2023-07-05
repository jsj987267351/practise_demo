package month05.day11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * https://leetcode.cn/problems/generate-parentheses/
 * @date 2023/5/11 16:29
 */
public class demo3 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
//        backtracking(result, stringBuilder, n, n);
        DFS(result,"",n,n);
        return result;
    }


    public void DFS(List<String> result, String string, int left, int right) {

//        左右括号都使用完了
        if (left == 0 && right == 0) {
            result.add(string);
            return;
        }
//        剪枝，左括号剩余数量应该严格小于等于右括号剩余数量
        if (left > right) {
            return;
        }
//        左括号还有剩余
        if (left > 0) {
            DFS(result,string+"(",left-1,right);
        }
//        右括号还有剩余
        if (right > 0) {
            DFS(result,string+")",left,right-1);
        }
    }


    //    这里的left和right代表左右括号的剩余使用数目
    public void backtracking(List<String> result, StringBuilder stringBuilder, int left, int right) {
//        左右括号都使用完了
        if (left == 0 && right == 0) {
            result.add(stringBuilder.toString());
            return;
        }
//        剪枝，左括号剩余数量应该严格小于等于右括号剩余数量
        if (left > right) {
            return;
        }
//        左括号还有剩余
        if (left > 0) {
            stringBuilder.append("(");
            backtracking(result, stringBuilder, left - 1, right);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
//        右括号还有剩余
        if (right > 0) {
            stringBuilder.append(")");
            backtracking(result, stringBuilder, left, right - 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }
}

