import java.util.*;

public class MaxFlow {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt() - 1;
        int t = scanner.nextInt() - 1;

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt() - 1;
            int v = scanner.nextInt() - 1;
            int c = scanner.nextInt();
            graph.get(u).add(new Edge(v, c));
        }

        int maxFlow = fordFulkerson(graph, s, t);
        System.out.println(maxFlow);
    }

    private static int fordFulkerson(List<List<Edge>> graph, int source, int sink) {
        int n = graph.size();
        int[][] residualCapacity = new int[n][n];

        for (int u = 0; u < n; u++) {
            for (Edge edge : graph.get(u)) {
                int v = edge.vertex;
                int capacity = edge.capacity;
                residualCapacity[u][v] += capacity;
            }
        }

        int maxFlow = 0;
        boolean[] visited = new boolean[n];

        while (true) {
            Arrays.fill(visited, false);
            int delta = dfs(residualCapacity, source, sink, visited, INF);
            if (delta == 0) {
                break;
            }
            maxFlow += delta;
        }

        return maxFlow;
    }

    private static int dfs(int[][] residualCapacity, int u, int sink, boolean[] visited, int minCapacity) {
        if (u == sink) {
            return minCapacity;
        }

        visited[u] = true;

        for (int v = 0; v < residualCapacity.length; v++) {
            if (!visited[v] && residualCapacity[u][v] > 0) {
                int delta = dfs(residualCapacity, v, sink, visited, Math.min(minCapacity, residualCapacity[u][v]));

                if (delta > 0) {
                    residualCapacity[u][v] -= delta;
                    residualCapacity[v][u] += delta;
                    return delta;
                }
            }
        }

        return 0;
    }

    static class Edge {
        int vertex;
        int capacity;

        public Edge(int vertex, int capacity) {
            this.vertex = vertex;
            this.capacity = capacity;
        }
    }
}
