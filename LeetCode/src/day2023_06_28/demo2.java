package day2023_06_28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 假设有打乱顺序的一群人站成一个队列，数组 people 表示队列中一些人的属性（不一定按顺序）。每个 people[i] = [hi, ki] 表示第 i 个人的身高为 hi ，前面 正好 有 ki 个身高大于或等于 hi 的人。
 * <p>
 * 请你重新构造并返回输入数组 people 所表示的队列。返回的队列应该格式化为数组 queue ，其中 queue[j] = [hj, kj] 是队列中第 j 个人的属性（queue[0] 是排在队列前面的人）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/queue-reconstruction-by-height
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/28 14:34
 */
public class demo2 {
    public int[][] reconstructQueue(int[][] people) {
//        先根据身高从大到小进行排列，这样身高这个维度就已经确定，如果身高相同，根据多少人比他高升序
//        然后根据每个人前面有多少大于等于这个人的数量(第二参数)插入到对应的位置
//        因为插入的话肯定是往比他高的队列里面插，所以不影响前面高的已经排好的序列
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) {
//                如果身高相同，则根据第二个参数升序
                return a[1] - b[1];
            } else {
//                身高不同，就按照身高降序
                return b[0] - a[0];
            }
        });

//        使用队列可以插到指定位置
        List<int[]> queue = new ArrayList<>();
//        遍历排序好的数组
        for (int[] person : people) {
            queue.add(person[1], person);
        }

        return queue.toArray(new int[people.length][]);
    }
}

