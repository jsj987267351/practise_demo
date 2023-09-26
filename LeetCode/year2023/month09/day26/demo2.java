package month09.day26;

import java.util.Arrays;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/26 13:01
 */
public class demo2 {
    public int bestSeqAtIndex(int[] height, int[] weight) {
//        与300 最长递增自律列解法相同，不过变换为2维而已
        int len = height.length;
        int[][] persons = new int[len][2];
        for (int i = 0; i < len; i++) {
            persons[i][0] = height[i];
            persons[i][1] = weight[i];
        }
//        身高升序，身高相同时体重降序
//        不能二者同为升序的原因时，身高相同时体重升序的话，那么计算子序列就会把二者都算进去，因为身高已经固定住只看体重了。那样是不符合要求的
        Arrays.sort(persons, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int res = 0;
        for (int[] person : persons) {
            int index = binarySearch(persons, res, person[1]);
            persons[index][1] = person[1];
            if (index == res) {
                res++;
            }
        }
        return res;
    }

    public int binarySearch(int[][] person, int right, int target) {
        int left = -1;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (person[mid][1] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}

