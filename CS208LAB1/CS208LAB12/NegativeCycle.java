import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class N {
    static void floydWarshall(int n, int[][] graph) {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE
                            && graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        // Check for negative cycle
        for (int i = 0; i < n; i++) {
            if (graph[i][i] < 0) {
                System.out.println("YES");
                return;
            }
        }

        System.out.println("NO");
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input.txt")); // 使用文件作为输入源

            int T = scanner.nextInt(); // 测试用例数

            for (int t = 0; t < T; t++) {
                int n = scanner.nextInt(); // 节点数
                int m = scanner.nextInt(); // 边数

                int[][] graph = new int[n][n];

                for (int i = 0; i < n; i++) {
                    Arrays.fill(graph[i], Integer.MAX_VALUE);
                    graph[i][i] = 0;
                }

                for (int i = 0; i < m; i++) {
                    int u = scanner.nextInt() - 1;
                    int v = scanner.nextInt() - 1;
                    int w = scanner.nextInt();

                    graph[u][v] = w;
                }

                floydWarshall(n, graph);
            }

            scanner.close(); // 关闭文件流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
