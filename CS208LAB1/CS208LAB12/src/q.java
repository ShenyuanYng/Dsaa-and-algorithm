import java.util.*;

class BellmanFord {
    static class Edge {
        int src, dest;
        long weight;

        Edge(int src, int dest, long weight) {
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

    static void initializeSingleSource(Graph graph, int source, long[] distance, int[] predecessor) {
        Arrays.fill(distance, Long.MAX_VALUE);
        Arrays.fill(predecessor, -1);
        distance[source] = 0;
    }

    static void relax(long[] distance, int[] predecessor, Edge edge) {
        int u = edge.src;
        int v = edge.dest;
        long w = edge.weight;

        if (distance[u] != Long.MAX_VALUE && distance[u] + w < distance[v]) {
            distance[v] = distance[u] + w;
            predecessor[v] = u;
        }
    }

    static boolean bellmanFord(Graph graph, int source, long[] distance, int[] predecessor) {
        initializeSingleSource(graph, source, distance, predecessor);


        for (int i = 0; i < graph.V - 1; i++) {
            // Relax each edge
            for (int j = 0; j < graph.E; j++) {
                relax(distance, predecessor, graph.edges[j]);
            }
        }

        for (int i = 0; i < graph.E; i++) {
            int u = graph.edges[i].src;
            int v = graph.edges[i].dest;
            long w = graph.edges[i].weight;

            if (distance[u] != Long.MAX_VALUE && distance[u] + w < distance[v]) {
                return true; // Negative cycle found
            }
        }

        return false; // No negative cycle
    }

    static void processConnectedComponents(Graph graph) {
        boolean[] visited = new boolean[graph.V];

        for (int i = 0; i < graph.V; i++) {
            if (!visited[i]) {
                long[] distance = new long[graph.V];
                int[] predecessor = new int[graph.V];

                if (bellmanFord(graph, i, distance, predecessor)) {
                    System.out.println("YES");
                    return;
                }

                for (int j = 0; j < graph.V; j++) {
                    if (distance[j] != Long.MAX_VALUE) {
                        visited[j] = true;
                    }
                }
            }
        }

        System.out.println("NO");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int V = scanner.nextInt();
            int E = scanner.nextInt();

            Graph graph = new Graph(V, E);

            for (int i = 0; i < E; i++) {
                int u = scanner.nextInt() - 1;
                int v = scanner.nextInt() - 1;
                long w = scanner.nextLong();

                graph.edges[i] = new Edge(u, v, w);
            }

            processConnectedComponents(graph);
        }
    }
}
