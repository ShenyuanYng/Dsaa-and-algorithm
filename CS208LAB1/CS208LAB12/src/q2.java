import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2{
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
        distance[source] = 0;
        for (int i = 0; i < graph.V; i++) {
            if (i != source) {
                distance[i] = Long.MAX_VALUE;
                predecessor[i] = -1;
            }
        }
    }

    static boolean relax(long[] distance, int[] predecessor, Edge edge) {
        int u = edge.src;
        int v = edge.dest;
        long w = edge.weight;

        if (distance[u] != Long.MAX_VALUE && distance[u] + w < distance[v]) {
            distance[v] = distance[u] + w;
            predecessor[v] = u;
            return true; // 发生了松弛
        }

        return false; // 未发生松弛
    }

    static boolean bellmanFord(Graph graph, int source, long[] distance, int[] predecessor) {
        initializeSingleSource(graph, source, distance, predecessor);

        // 执行 |V| - 1 次松弛
        for (int i = 0; i < graph.V - 1; i++) {
            boolean relaxed = false;

            // 松弛每条边
            for (int j = 0; j < graph.E; j++) {
                relaxed |= relax(distance, predecessor, graph.edges[j]);
            }

            if (!relaxed) {
                break; // 如果未发生松弛，提前退出
            }
        }

        // 检查是否存在负权环
        for (int j = 0; j < graph.E; j++) {
            if (relax(distance, predecessor, graph.edges[j])) {
                return true; // 负权环存在
            }
        }

        return false; // 不存在负权环
    }

    static boolean hasNegativeCycle(Graph graph) {
        long[] distance = new long[graph.V];
        int[] predecessor = new int[graph.V];

        for (int i = 0; i < graph.V; i++) {
            if (bellmanFord(graph, i, distance, predecessor)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int V = Integer.parseInt(tokenizer.nextToken());
            int E = Integer.parseInt(tokenizer.nextToken());

            Graph graph = new Graph(V, E);

            for (int i = 0; i < E; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int u = Integer.parseInt(tokenizer.nextToken()) - 1;
                int v = Integer.parseInt(tokenizer.nextToken()) - 1;
                long w = Long.parseLong(tokenizer.nextToken());

                graph.edges[i] = new Edge(u, v, w);
            }

            if (hasNegativeCycle(graph)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
