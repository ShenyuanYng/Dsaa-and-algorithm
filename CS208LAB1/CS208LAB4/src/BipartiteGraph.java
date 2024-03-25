import java.util.*;

public class BipartiteGraph {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 读取测试用例的数量

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); // 顶点数
            int M = scanner.nextInt(); // 边数

            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int i = 0; i < M; i++) {
                int U = scanner.nextInt() - 1;
                int V = scanner.nextInt() - 1;
                adjList.get(U).add(V);
                adjList.get(V).add(U);
            }

            boolean isBipartite = isBipartiteGraph(N, adjList);
            System.out.println(isBipartite ? "true" : "false");
        }
    }

    public static boolean isBipartiteGraph(int N, List<List<Integer>> adjList) {
        int[] color = new int[N]; // 用于标记顶点的颜色，0表示未访问，1和2表示两个不同的颜色
        Arrays.fill(color, 0);

        for (int i = 0; i < N; i++) {
            if (color[i] == 0) {
                if (!bipartiteBFS(i, color, adjList)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean bipartiteBFS(int start, int[] color, List<List<Integer>> adjList) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 1; // 将起始顶点标记为第一种颜色

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adjList.get(node)) {
                if (color[neighbor] == 0) {
                    color[neighbor] = 3 - color[node]; // 使用位运算来交替标记颜色
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false; // 发现相邻顶点具有相同的颜色，不是二部图
                }
            }
        }

        return true;
    }
}
