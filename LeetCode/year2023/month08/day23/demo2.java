package month08.day23;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/8/23 13:27
 */
public class demo2 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
//        注意资本不扣除，利润纯加
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < profits.length; i++) {
//            首先收集所有项目
            list.add(new int[]{capital[i], profits[i]});
        }
//        先按照项目启动资金升序排序
        list.sort((a, b) -> a[0] - b[0]);
//        大根堆,堆中存放的是当前能负担得起启动资金的各个项目的纯利润
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
//        项目的索引，列表中项目已经按照启动资金进行升序排序过了
        int index = 0;
        while (k-- > 0) {
//            每次index不用重新置0和堆不用清空的原因是资本是一定不断增加或者不动的，不可能减少
//            所以前面能付得起的项目资本更新后一定仍然付得起，只需要额外在增加更新资本后能付得起的项目利润即可

//            首先将所有当前能付得起的项目的纯利润都加入堆中
            while (index < list.size() && w >= list.get(index)[0]) {
                maxHeap.offer(list.get(index++)[1]);
            }
//            如果当前资本任何项目都付不起了，直接结束
            if (maxHeap.isEmpty()) break;
//            取出能负担的起的项目中利润最大的项目来更新资本
            w += maxHeap.poll();
        }

        return w;
    }
}

