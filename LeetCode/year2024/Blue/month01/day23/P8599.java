package Blue.month01.day23;

import java.util.*;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/23 13:35
 */
public class P8599 {
    private static int target;
    private static LinkedList<Integer> path;
    private static int res = 0;
    private static int[] temp = new int[9];
    private static boolean[] used;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        target = scanner.nextInt();
        path = new LinkedList<>();
        used = new boolean[9];
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        backtracking(nums);
        System.out.println(res);
        scanner.close();
    }

    //    全排列
    public static void backtracking(int[] nums) {
        if (path.size() == nums.length) {
            for (int i = 0; i < 9; i++) {
                temp[i] = path.get(i);
            }
            check(temp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums);
            path.removeLast();
            used[i] = false;
        }
    }

    //    判断当前排列是否可行
    public static void check(int[] temp) {
//        分子和分母至少占两个数，所以整数最多用7个数字
        for (int i = 0; i < 7; i++) {
//            拿到整数
            int num = toInt(temp, 0, i);
//            拿到整数已经比结果数字大了，剪枝
            if (num >= target) {
                continue;
            }
//            拿分母与分子,前面算分母还是分子都可以，因为所有排列都会进来,这里先拿分母，最少要留一个数字给分子
            for (int j = i + 1; j < 8; j++) {
                int mother = toInt(temp, i + 1, j);
                int son = toInt(temp, j + 1, 8);
//                判断
                if (son % mother == 0 && num + (son / mother) == target) {
                    res++;
                }
            }
        }
    }

    //    将数组[left,right]数字组合成整数
    public static int toInt(int[] temp, int left, int right) {
        int res = 0;
        while (left <= right) {
            res = res * 10 + temp[left++];
        }
        return res;
    }
}
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int res = 0;
//        StringBuilder s;
////        整数部分
//        for (int i = 1; i < n; i++) {
////            分母
//            for (int j = 1; j < 5000; j++) {
////                分子
//                s = new StringBuilder();
//                int k = (n - i) * j;
//                s.append(i).append(j).append(k);
//                char[] chars = s.toString().toCharArray();
//                Arrays.sort(chars);
//                String copy = String.valueOf(chars);
//                if ("123456789".equals(copy)) {
//                    res++;
//                }
//            }
//        }
//        System.out.println(res);
//        scanner.close();
//    }


