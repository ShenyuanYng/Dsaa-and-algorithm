import java.util.*;

public class GraphPaths {
    private static final int MOD = 1000000007;

    static class Edge {
        int to, weight;

        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static int dijkstra(List<Edge>[] graph, int start, int end) {
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int node = current.to;

            if (dist[node] < current.weight) continue;

            for (Edge edge : graph[node]) {
                int nextNode = edge.to;
                int nextDist = dist[node] + edge.weight;

                if (nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist;
                    pq.add(new Edge(nextNode, nextDist));
                }
            }
        }

        return dist[end];
    }

    private static int countPaths(List<Edge>[] graph, int start, int end, int maxWeight) {
        // This function will require additional data structures and logic to count the paths
        // considering the weight constraint. You can use DFS with memoization or BFS to
        // enumerate the paths while keeping track of the current weight.
        return -1; // placeholder for actual path count
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();  // Number of test cases

        while (T-- > 0) {
            int n = scanner.nextInt();  // Number of vertices
            int m = scanner.nextInt();  // Number of edges
            int K = scanner.nextInt();  // Additional weight allowance
            int P = scanner.nextInt();  // Modulo value

            List<Edge>[] graph = new List[n + 1]; for (int i = 1; i <= n; i++)
            { graph[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                graph[u].add(new Edge(v, w));
            }
            int shortestPathWeight = dijkstra(graph, 1, n);
            int pathCount = countPaths(graph, 1, n, shortestPathWeight + K);
            System.out.println(pathCount >= 0 ? pathCount % P : -1);
        }
        scanner.close();
    }
}