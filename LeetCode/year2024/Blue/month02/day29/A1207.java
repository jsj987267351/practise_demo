package Blue.month02.day29;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/2/29 13:56
 */
public class A1207 {
    public static List<Node> gra[];
    public static int MaxId = 0;
    public static long MaxLen = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        gra = new ArrayList[T + 1];
        for (int i = 0; i < T + 1; i++) {
            gra[i] = new ArrayList<>();
        }
        for (int i = 0; i < T - 1; i++) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            int len = scanner.nextInt();
            gra[p].add(new Node(q, len));
            gra[q].add(new Node(p, len));
        }
        DFS(1, 1, 0);
        DFS(MaxId, MaxId, 0);
        long res = 10 * MaxLen + ((1 + MaxLen) * MaxLen) / 2;
        System.out.println(res);
        scanner.close();
    }


    public static void DFS(int cur, int from, long sum) {
        List<Node> Nodes = gra[cur];
        boolean isEnd = true;
        for (Node node : Nodes) {
            if (node.id == from) continue;
            DFS(node.id, cur, sum + node.len);
            isEnd = false;
        }
        if (isEnd && sum > MaxLen) {
            MaxLen = sum;
            MaxId = cur;
        }
    }

    static class Node {
        int id;
        int len;

        public Node(int id, int len) {
            this.id = id;
            this.len = len;
        }
    }
}

