package day06;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
public class demo2 {
    public boolean canConstruct(String ransomNote, String magazine) {

        if(ransomNote.length() > magazine.length()){
            return false;
        }

        int[] int1 = new int[26];
        int[] int2 = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            int1[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            int2[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if(int1[i] > int2[i]){
                return false;
            }
        }
        return true;
    }
}
