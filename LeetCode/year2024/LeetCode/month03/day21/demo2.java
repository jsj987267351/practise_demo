package LeetCode.month03.day21;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/3/21 12:58
 */
public class demo2 {
    class FrequencyTracker {
        //        统计每个数字出现的频率
        int[] num;
        //        用来统计每个频率出现的频率
        int[] fre;

        public FrequencyTracker() {
            num = new int[100100];
            fre = new int[100100];
        }

        public void add(int number) {
            if (num[number] > 0) {
                fre[num[number]]--;
            }
            num[number]++;
            fre[num[number]]++;
        }

        public void deleteOne(int number) {
            if (num[number] == 0) return;
            fre[num[number]]--;
            num[number]--;
            fre[num[number]]++;
        }

        public boolean hasFrequency(int frequency) {
            return fre[frequency] > 0;
        }
    }
}

