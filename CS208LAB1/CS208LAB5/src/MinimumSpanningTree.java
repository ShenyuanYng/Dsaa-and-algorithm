import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int to;
    int weight;

    public Edge(int to, int weight) {
        this.to = to;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

public class MinimumSpanningTree {
    public static int primMST(List<List<Edge>> graph) {
        int n = graph.size();
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        int totalWeight = 0;
        pq.add(new Edge(0, 0)); // Start from vertex 0.

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int to = edge.to;
            int weight = edge.weight;

            if (visited[to]) {
                continue;
            }

            visited[to] = true;
            totalWeight += weight;

            for (Edge neighbor : graph.get(to)) {
                if (!visited[neighbor.to]) {
                    pq.add(neighbor);
                }
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int T = Integer.parseInt(br.readLine()); // 测试用例的数量
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 顶点数量
            int m = Integer.parseInt(st.nextToken()); // 边数量
            List<List<Edge>> graph = new ArrayList<>(n);

            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                graph.get(u - 1).add(new Edge(v - 1, w));
                graph.get(v - 1).add(new Edge(u - 1, w));
            }

            int mstWeight = primMST(graph);
            pw.println(mstWeight); // 输出最小生成树的权重和
        }

        pw.close();
    }
}
