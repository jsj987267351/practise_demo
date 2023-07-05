package month04.day17;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * @date 2023/4/17 12:19
 */
public class demo3 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        int[] ints = new int[rowIndex + 1];

        for (int i = 0; i <= rowIndex; i++) {
            temp(ints, i);
        }
        for (int a : ints) {
            result.add(a);
        }
        return result;
    }

    public void temp(int[] n, int i) {
        if (i == 0) {
            n[0] = 1;
            return;
        }
        for (int j = i; j > 0; j--) {
            n[j] = n[j] + n[j - 1];
        }
    }
}

