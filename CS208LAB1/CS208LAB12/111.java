import java.util.*;

class BellmanFord {
    static class Edge {
        int src, dest, weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    static class Graph {
        int V, E;
        Edge[] edges;

        Graph(int V, int E) {
            this.V = V;
            this.E = E;
            edges = new Edge[E];
        }
    }

    static void initializeSingleSource(Graph graph, int source, int[] distance) {
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
    }

    static void relax(int[] distance, Edge edge) {
        int u = edge.src;
        int v = edge.dest;
        int w = edge.weight;

        if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
            distance[v] = distance[u] + w;
        }
    }

    static boolean bellmanFord(Graph graph, int source) {
        int[] distance = new int[graph.V];
        initializeSingleSource(graph, source, distance);

        // |V| - 1 passes
        for (int i = 1; i <= graph.V - 1; i++) {
            // Relax each edge
            for (int j = 0; j < graph.E; j++) {
                relax(distance, graph.edges[j]);
            }
        }

        // Check for negative-weight cycle
        for (int i = 0; i < graph.E; i++) {
            int u = graph.edges[i].src;
            int v = graph.edges[i].dest;
            int w = graph.edges[i].weight;

            if (distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]) {
                return false; // Negative cycle found
            }
        }

        return true; // No negative cycle
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // 测试用例数

        for (int t = 0; t < T; t++) {
            int V = scanner.nextInt(); // 节点数
            int E = scanner.nextInt(); // 边数

            Graph graph = new Graph(V, E);

            for (int i = 0; i < E; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                int w = scanner.nextInt();

                graph.edges[i] = new Edge(u, v, w);
            }

            // 输出结果
            if (bellmanFord(graph, 0)) {
                System.out.println("TRUE");
            } else {
                System.out.println("FALSE");
            }
        }
    }
}
