package month12.day27;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/27 12:12
 */
public class demo1 {
    public int isWinner(int[] player1, int[] player2) {
        int score1 = 0, score2 = 0;
        for (int i = 0; i < player1.length; i++) {
            if (i > 0 && player1[i - 1] == 10 || i > 1 && player1[i - 2] == 10) {
                score1 += player1[i] * 2;
            } else {
                score1 += player1[i];
            }
            if (i > 0 && player2[i - 1] == 10 || i > 1 && player2[i - 2] == 10) {
                score2 += player2[i] * 2;
            } else {
                score2 += player2[i];
            }
        }
        if (score1 > score2) {
            return 1;
        } else if (score1 < score2) {
            return 2;
        } else return 0;
    }
}

