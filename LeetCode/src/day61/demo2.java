package day61;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date 2023/6/12 13:54
 */
public class demo2 {
    boolean[][] used;
    int rowLength;
    int colLength;

    public boolean exist(char[][] board, String word) {
        rowLength = board.length;
        colLength = board[0].length;
        char[] words = word.toCharArray();
        used = new boolean[rowLength][colLength];
//        判断每个节点作为起点是否可行
        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < colLength; j++) {
                if (dfs(board, i, j, 0, words)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int row, int col, int index, char[] words) {
//        进行结束条件判断
//        特判边界
        if (row < 0 || col < 0 || row >= rowLength || col >= colLength) {
            return false;
        }
//        当前字母已经使用过，所以返回false，避免回头路重复使用
        if (used[row][col]) {
            return false;
        }
//        遍历到字符串的最后一位了，所以直接判断当前字母是否符合即可，符合则相当于全部判断完成
        if (index == words.length - 1) {
            return board[row][col] == words[index];
        }
//        如果遍历到的当前单词与目标单词的索引下标字母不一致，直接返回false
        if (board[row][col] != words[index]) {
            return false;
        }
//        当前单词标记为已使用
        used[row][col] = true;
//        向上下左右都进行移动
        boolean up = dfs(board, row - 1, col, index + 1, words);
        boolean right = dfs(board, row, col + 1, index + 1, words);
        boolean down = dfs(board, row + 1, col, index + 1, words);
        boolean left = dfs(board, row, col - 1, index + 1, words);
//        回溯
        used[row][col] = false;
//        判断上下左右是否有一个方向符合
        return up || right || down || left;
    }
}

