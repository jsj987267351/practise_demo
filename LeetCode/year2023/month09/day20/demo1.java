package month09.day20;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/t9-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/20 12:20
 */
public class demo1 {
    List<String> res;
    Map<Character, Character> keys;

    public List<String> getValidT9Words1(String num, String[] words) {
        res = new ArrayList<>();
        keys = new HashMap<>();
        keys.put('a', '2');
        keys.put('b', '2');
        keys.put('c', '2');
        keys.put('d', '3');
        keys.put('e', '3');
        keys.put('f', '3');
        keys.put('g', '4');
        keys.put('h', '4');
        keys.put('i', '4');
        keys.put('j', '5');
        keys.put('k', '5');
        keys.put('l', '5');
        keys.put('m', '6');
        keys.put('n', '6');
        keys.put('o', '6');
        keys.put('p', '7');
        keys.put('q', '7');
        keys.put('r', '7');
        keys.put('s', '7');
        keys.put('t', '8');
        keys.put('u', '8');
        keys.put('v', '8');
        keys.put('w', '9');
        keys.put('x', '9');
        keys.put('y', '9');
        keys.put('z', '9');
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!keys.get(c).equals(num.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(word);
            }
        }
        return res;
    }


    public List<String> getValidT9Words(String num, String[] words) {
        List<String>res = new ArrayList<>();
//        因为字母是按顺序排列得，所以可以直接用数组存储
        char[] chars = "22233344455566677778889999".toCharArray();
        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (num.charAt(i) != chars[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(word);
            }
        }
        return res;
    }
}

