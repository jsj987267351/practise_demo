package Blue.month01.day31;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/31 15:53
 */
public class P9234 {
    private static int res = 50;
    private static int[] arr;
    private static int target;
    private static int n;
    private static int preIndex;
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        map存储前半段每个重量最少要切多少刀
        n = scanner.nextInt();
        target = scanner.nextInt();
//        总重量*2，避免切瓜切到小数后被四舍五入，缺失精度
        target *= 2;
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
//            同理
            arr[i] *= 2;
        }
//       将数组倒排，重量大的往前，这样能确保切刀数更少
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
//        前半段索引
        preIndex = n / 2;
        DFS1(0, 0, 0);
        DFS2(0, preIndex + 1, 0);
        if (res == 50) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
        scanner.close();
    }

    //      参数：当前总重量，索引，当前已经切了多少刀
    public static void DFS1(int totalHeavy, int index, int count) {
        //      切刀数太大 、   总重量已经超过结果 、 剩余重量不足
        if (count >= res || totalHeavy > target) return;
//        不用所有瓜都买，只要能买够重量target即可,这里不用Math.min是因为前面刀数多的时候已经return了，所以符合当前条件是count一定小于res
        if (totalHeavy == target) {
            res = count;
            return;
        }
//        索引到中间，更新map重量
        if (index > preIndex) {
            if (!map.containsKey(totalHeavy)) {
                map.put(totalHeavy, count);
            } else {
                map.put(totalHeavy, Math.min(map.get(totalHeavy), count));
            }
            return;
        }
//        三种情况，不买、买半个、买整个
        DFS1(totalHeavy, index + 1, count);
        DFS1(totalHeavy + arr[index] / 2, index + 1, count + 1);
        DFS1(totalHeavy + arr[index], index + 1, count);
    }

    //      参数：当前总重量，索引，当前已经切了多少刀
    public static void DFS2(int totalHeavy, int index, int count) {
        //      切刀数太大 、   总重量已经超过结果 、 剩余重量不足
        if (count >= res || totalHeavy > target) return;
//        不用所有瓜都买，只要能买够重量target即可,这里不用Math.min是因为前面刀数多的时候已经return了，所以符合当前条件是count一定小于res
        if (totalHeavy == target) {
            res = count;
            return;
        }
//        索引到达最后，判断前半段
        if (index == n) {
            if (map.containsKey(target - totalHeavy)) {
                res = Math.min(res, count + map.get(target - totalHeavy));
            }
            return;
        }
//        三种情况，不买、买半个、买整个
        DFS2(totalHeavy, index + 1, count);
        DFS2(totalHeavy + arr[index] / 2, index + 1, count + 1);
        DFS2(totalHeavy + arr[index], index + 1, count);
    }
}

