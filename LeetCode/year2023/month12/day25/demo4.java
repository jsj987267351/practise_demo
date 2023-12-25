package month12.day25;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/25 14:23
 */
public class demo4 {
    public int findClosest(String[] words, String word1, String word2) {
        int res = Integer.MAX_VALUE;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) index1 = i;
            if (word2.equals(words[i])) index2 = i;
            if (index1 != -1 && index2 != -1) {
                res = Math.min(res, Math.abs(index1 - index2));
                if (res == 1){
                    return res;
                }
            }
        }
        return res;
    }
}

