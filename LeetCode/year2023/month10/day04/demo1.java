package month10.day04;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description
 * @date 2023/10/4 12:12
 */
public class demo1 {
    public List<String> computeSimilarities(int[][] docs) {
        List<String> res = new ArrayList<>();
        int rowLength = docs.length;
//        help[i][j]表示第i个数组与第j个数组的交集数量
        int[][] help = new int[rowLength][rowLength];
//        key表示出线的数字，value表示该数字在哪些数组中出现过
        Map<Integer, List<Integer>> map = new HashMap<>();
//       开始遍历
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < docs[i].length; j++) {
//                首先查看出现过该数字的数组该数字,其中i表示该数字出现的数组
                List<Integer> list = map.get(docs[i][j]);
                if (list == null) {
//                    表示该数字第一次出现,创建该数字对应的数量并且加入集合中
                    list = new ArrayList<>();
                    map.put(docs[i][j], list);
                } else {
//                    表示该数字在前面遍历过的数组中出现过，所以该数组所在数组与前面出现过该数字的数组的并集+1
                    for (int listIndex : list) {
                        help[i][listIndex]++;
                    }
                }
//                该数字出现在第i个数组，所以将i加入该数字对应的数组中
                list.add(i);
            }
//            此时的第i行就已经计算完了在该行他前面的所有行的交集，可以拼接加入结果中了
            for (int j = 0; j < i; j++) {
//                这里要使用help[i][j]而不是help[j][i]是因为我们前面是得出了第i行与其他行的交集
                if (help[i][j] > 0) {
                    res.add(j + "," + i + ": " + String.format("%.4f", (double) help[i][j] / (docs[i].length + docs[j].length - help[i][j])));
                }
            }
        }
        return res;
    }
}

