package day2023_03_20;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * https://leetcode.cn/problems/pascals-triangle/
 */
public class demo2 {
    public List<List<Integer>> generate(int numRows) {
         List<List<Integer>> result = new ArrayList<List<Integer>>();
        int[] row = new int[numRows];
        for (int i = 0; i < numRows; i++) {
            createRow(row,i);
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <=i ; j++) {
                temp.add(row[j]);
            }
            result.add(temp);
        }
        return result;
    }

    public void createRow(int [] row , int i){
        if(i ==0){
            row[0] = 1;
            return;
        }
        for (int j = i; j > 0; j--) {
            row[j] = row[j] + row[j-1];
        }
    }
}
