package month03.day31;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 * @date 2023/3/31 14:07
 */
public class demo2 {
    public int[] twoSum1(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 1; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length + 1; j++) {
                if (numbers[i - 1] + numbers[j - 1] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }


    public int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (numbers[i] + numbers[m] > target) {
                j = m;
            } else if (numbers[j] + numbers[m] < target) {
                i = m;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            }
        }
        return result;
    }
}

