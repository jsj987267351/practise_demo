package Blue.month01.day27;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：大爆炸
 * @version 1.0
 * @description TODO
 * @date 2024/1/27 14:59
 */
public class P8602 {
    //    最大经历路程
    private static int max = 0;
    private static int maxNodeId;
    private static List<Node> graph[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        graph = new ArrayList[T + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < T - 1; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int len = scanner.nextInt();
            graph[a].add(new Node(b, len));
            graph[b].add(new Node(a, len));
        }
        DFS(1, 1, 0);
        DFS(maxNodeId, maxNodeId, 0);
//        个位数用等差数列
        int res = max * 10 + (max * (1 + max)) / 2;
        System.out.println(res);
        scanner.close();
    }

    public static void DFS(int cur, int from, int sum) {
        List<Node> nodes = graph[cur];
        boolean isEnd = true;
        for (Node node : nodes) {
            if (node.id == from) continue;
            DFS(node.id, cur, sum + node.length);
            isEnd = false;
        }
        if (isEnd && sum > max) {
            max = sum;
            maxNodeId = cur;
        }
    }

    static class Node {
        int id;
        int length;

        public Node(int id, int length) {
            this.id = id;
            this.length = length;
        }
    }
}

