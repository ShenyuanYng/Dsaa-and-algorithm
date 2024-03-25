import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NewYearVillages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 村庄的数量
        int m = scanner.nextInt(); // 道路的数量
        int p = scanner.nextInt(); // XX初始所在的村庄
        int q = scanner.nextInt(); // 问题的数量

        // 创建邻接表来表示村庄之间的连接关系
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] minDistance = new int[n + 1];

        // 初始化最短距离数组
        for (int i = 1; i <= n; i++) {
            minDistance[i] = (i == p) ? 0 : Integer.MAX_VALUE;
        }

        // 使用BFS计算最短距离
        bfs(graph, p, minDistance);

        for (int i = 0; i < q; i++) {
            int k = scanner.nextInt();
            int count = countVillagesWithinKDistance(minDistance, k);
            System.out.print(count-1 + " ");
        }
    }

    private static void bfs(ArrayList<Integer>[] graph, int start, int[] minDistance) {
        boolean[] visited = new boolean[minDistance.length];
        visited[start] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                    minDistance[neighbor] = minDistance[current] + 1;
                }
            }
        }
    }

    private static int countVillagesWithinKDistance(int[] minDistance, int k) {
        int count = 0;
        for (int distance : minDistance) {
            if (distance <= k) {
                count++;
            }
        }
        return count;
    }
}
