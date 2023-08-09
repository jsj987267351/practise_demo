package month08.day09;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/text-justification/description/?envType=study-plan-v2&envId=top-interview-150
 * @date 2023/8/9 16:48
 */
public class demo2 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();

//        记录当前计算的长度
        int count = 0;
        int start = 0;
        for (int i = 0; i < words.length; i++) {
            count += words[i].length();
//            如果当前计算的长度已经大于 maxWidth 了，说明当前的字符串需要处理后加入结果中
            if (count > maxWidth) {
//                使用i-1是因为当前字符加上的话就不满足，所以到前一个截止，使用左闭右闭原则
                res.add(help(words, start, i - 1, maxWidth));
//               更新其实位置，因为当前不符合的，所以当前为下一数组的起始
                start = i;
//                长度更新为当前字符串的长度
                count = words[i].length();
            }
//            因为每个字符串中间最少要加一个空格，所以长度要++
            count++;
        }

//        因为上述循环处理的时候都是到i-1，所以即使遍历完了数组，最后一截也还没处理，但是start记录了最后一截需要处理的开头，单独处理一次即可
        res.add(help(words, start, words.length - 1, maxWidth));
        return res;
    }

    public String help(String[] words, int start, int end, int maxWidth) {
        StringBuilder sb = new StringBuilder();
//        分为三种情况
        if (start == end) {
//            说明当前行只够放下一个字符串，特殊处理
            oneRow(words, start, end, maxWidth, sb);
        } else if (end == words.length - 1) {
//            说明当前行的截止位置到了数组中最后一个字符串，特殊处理
            endRow(words, start, end, maxWidth, sb);
        } else {
//            其他情况普通处理
            normal(words, start, end, maxWidth, sb);
        }
        return sb.toString();
    }

    public void oneRow(String[] words, int start, int end, int maxWidth, StringBuilder sb) {
//            只能放下一个字符串的话，就放下当前字符串后剩余位置全都加空格即可
        sb.append(words[start]);
        int len = maxWidth - words[start].length();
        for (int i = 0; i < len; i++) {
            sb.append(" ");
        }
    }

    public void endRow(String[] words, int start, int end, int maxWidth, StringBuilder sb) {
//        最后一行的话，每个字符串之间只加一个空格，剩余位置全放空格即可,保持左闭右闭原则，所以是小于等于
        for (int i = start; i <= end; i++) {
//            每次先加字符串
            sb.append(words[i]);
            if (i == end) {
//                如果已经加完了最后一个字符串，那么剩余位置全加空格
                int len = maxWidth - sb.length();
                for (int j = 0; j < len; j++) {
                    sb.append(" ");
                }
            } else {
//                否则每个字符之间只加一个空格
                sb.append(" ");
            }
        }
    }

    public void normal(String[] words, int start, int end, int maxWidth, StringBuilder sb) {
//        平常处理情况的话，首先计算一共字符串的长度为多少，剩余的位置即是空格。将空格首先平均放在每个字符串中间，然后多余的空格依次往左放
//        计算字符串的总长度
        int count = 0;
        for (int i = start; i <= end; i++) {
            count += words[i].length();
        }
//        计算需要空格数
        int countSpace = maxWidth - count;
//       计算平均每个字符串中间需要放几个空格,这里用end - start 是因为两端不需要放空格，所以字符中间的空隙数字比字符串数字少一个
//        end - start +1 是字符串数字  例如3个字符串中间只有2个空隙
        int average = countSpace / (end - start);
//        计算余下多少空格
        int remain = countSpace % (end - start);
//        开始放空格
        for (int i = start; i <= end; i++) {
//            首先加上当前字符串
            sb.append(words[i]);
//            最后一个字符串后面不用放空格
            if (i != end) {
//            加上需要放的平均空格
                for (int j = 0; j < average; j++) {
                    sb.append(" ");
                }
//            剩余空格要依次从左往右放，每次放一个,直至放完
                if (remain > 0) {
                    sb.append(" ");
                    remain--;
                }
            }
        }
    }
}

