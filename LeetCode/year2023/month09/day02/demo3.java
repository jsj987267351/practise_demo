package month09.day02;

import java.util.LinkedList;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description https://leetcode.cn/problems/animal-shelter-lcci/?envType=study-plan-v2&envId=cracking-the-coding-interview
 * @date 2023/9/2 12:23
 */
public class demo3 {
    class AnimalShelf {
        LinkedList<Integer> catStack;
        LinkedList<Integer> dogStack;

        public AnimalShelf() {
            catStack = new LinkedList<>();
            dogStack = new LinkedList<>();
        }

        public void enqueue(int[] animal) {
            if (animal[1] == 0) {
                catStack.push(animal[0]);
            } else {
                dogStack.push(animal[0]);
            }
        }

        public int[] dequeueAny() {
            if (catStack.isEmpty() && dogStack.isEmpty()) {
                return new int[]{-1, -1};
            }
            if (!catStack.isEmpty() && !dogStack.isEmpty()) {
                int catIndex = catStack.getLast();
                int dogIndex = dogStack.getLast();
                if (catIndex < dogIndex) {
                    return new int[]{catStack.removeLast(), 0};
                }
                return new int[]{dogStack.removeLast(), 1};
            }
            if (!dogStack.isEmpty()) {
                return new int[]{dogStack.removeLast(), 1};
            }
            return new int[]{catStack.removeLast(), 0};
        }

        public int[] dequeueDog() {
            if (dogStack.isEmpty()) {
                return new int[]{-1, -1};
            }
            return new int[]{dogStack.removeLast(), 1};
        }

        public int[] dequeueCat() {
            if (catStack.isEmpty()) {
                return new int[]{-1, -1};
            }
            return new int[]{catStack.removeLast(), 0};
        }
    }

}

