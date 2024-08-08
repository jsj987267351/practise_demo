package LeetCode.month08.day08;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/8/8 17:26
 */
public class demo1 {
    class FrequencyTracker {
        int[] num;
        int[] fre;

        public FrequencyTracker() {
            num = new int[100010];
            fre = new int[100010];
        }

        public void add(int number) {
            fre[num[number]]--;
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

