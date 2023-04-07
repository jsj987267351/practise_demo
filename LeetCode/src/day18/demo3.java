package day18;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/roman-to-integer/
 * @date 2023/4/7 15:58
 */
public class demo3 {
    public int romanToInt1(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        if (s.length() == 1) {
            return map.get(s);
        }
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i == 0) {
                result += map.get(String.valueOf(s.charAt(0)));
                break;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s.charAt(i - 1));
            stringBuilder.append(s.charAt(i));
            String s1 = stringBuilder.toString();
            if (map.get(s1) == null) {
                result += map.get(String.valueOf(s.charAt(i)));
            } else {
                result += map.get(s1);
                i--;
            }
        }
        return result;
    }

    public int romanToInt2(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        if (s.length() == 1) {
            return map.get(s);
        }
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i == 0) {
                result += map.get(String.valueOf(s.charAt(0)));
                break;
            }
            Integer back = map.get(String.valueOf(s.charAt(i)));
            Integer front = map.get(String.valueOf(s.charAt(i - 1)));
            if (back > front) {
                result += back - front;
                i--;
            } else {
                result += back;
            }
        }
        return result;
    }

    public int romanToInt3(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i == 0) {
                result += map.get(String.valueOf(s.charAt(0)));
                break;
            }
            Integer back = map.get(String.valueOf(s.charAt(i)));
            Integer front = map.get(String.valueOf(s.charAt(i - 1)));
            if (back > front) {
                result += back - front;
                i--;
            } else {
                result += back;
            }
        }
        return result;
    }

    public int romanToInt(String s) {
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i == 0) {
                result += value(s.charAt(0));
                break;
            }
            Integer back = value(s.charAt(i));
            Integer front = value(s.charAt(i-1));
            if (back > front) {
                result += back - front;
                i--;
            } else {
                result += back;
            }
        }
        return result;
    }

    public int value(char c){
        switch (c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default: return 0;
        }
    }
}

