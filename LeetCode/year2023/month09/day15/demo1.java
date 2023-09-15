package month09.day15;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2023/9/15 12:20
 */
public class demo1 {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
        return numbers;
    }
}

