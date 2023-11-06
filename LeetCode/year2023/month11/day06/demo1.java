package month11.day06;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/maximum-product-of-word-lengths/description/?envType=daily-question&envId=2023-11-06
 * @date 2023/11/6 12:08
 */
public class demo1 {
    public int maxProduct(String[] words) {
//        可看官方解析更完整
        int length = words.length;
//        mask数组存放的是words中每个单词的位掩码，int有32位，小写字母只需要最后26位来记录当前字母是否出现过，出现过的话对应位就为1
//        最后将每个单词的位掩码进行与运算，只有两个单词与运算为0才代表两个单词没有相同字母，因为与运算只有两个都为1时才为1，其余都为0，所以只有当两个字符串都存在这个字母时才为1
        int[] mask = new int[length];
        for (int i = 0; i < length; i++) {
            String curString = words[i];
            for (int j = 0; j < curString.length(); j++) {
//                进行或运算，即将int的后26位来定义小写字母是否出现过，出现则为1，例如当前字母为b，减去'a'后对应位置下标为倒数第二，将当前位置为1后进行或运算，当前位置就可为1
                mask[i] = mask[i] | 1 << (curString.charAt(j) - 'a');
            }
        }
        int res = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((mask[i] & mask[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    public int maxProduct1(String[] words) {
//        暴力搜索
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (help(words[i], words[j])) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }
        return res;
    }

    public boolean help(String a, String b) {
        boolean[] exist = new boolean[26];
        for (int i = 0; i < a.length(); i++) {
            exist[a.charAt(i) - 'a'] = true;
        }
        for (int i = 0; i < b.length(); i++) {
            if (exist[b.charAt(i) - 'a']) {
                return false;
            }
        }
        return true;
    }
}

