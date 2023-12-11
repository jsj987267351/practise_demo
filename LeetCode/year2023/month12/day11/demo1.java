package month12.day11;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/12/11 12:40
 */
public class demo1 {
    public int encryptionCalculate(int dataA, int dataB) {
        while (dataB != 0) {
            int temp = (dataA & dataB) << 1;
            dataA = dataA ^ dataB;
            dataB = temp;
        }
        return dataA;
    }
}

