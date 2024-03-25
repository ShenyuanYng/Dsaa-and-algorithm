import java.io.*;
import java.util.*;

class q1 {
    static class Edge {
        int to, weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(reader.readLine());

        while (T-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());
            int K = Integer.parseInt(tokenizer.nextToken());
            int P = Integer.parseInt(tokenizer.nextToken());

            List<List<Edge>> graph = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < m; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int u = Integer.parseInt(tokenizer.nextToken());
                int v = Integer.parseInt(tokenizer.nextToken());
                int w = Integer.parseInt(tokenizer.nextToken());
                graph.get(u).add(new Edge(v, w));
            }

            int result = countPaths(graph, n, K);
            writer.write(result + "\n");
        }

        writer.flush();
        writer.close();
    }

    static int countPaths(List<List<Edge>> graph, int n, int K) {
        int[] pathCount = { 0 }; // Using an array to pass by reference

        // Start DFS from vertex 1
        dfs(graph, 1, n, K, pathCount, 0);

        return pathCount[0];
    }

    static void dfs(List<List<Edge>> graph, int current, int target, int K, int[] pathCount, int currentWeight) {
        if (current == target) {
            if (currentWeight <= K) {
                pathCount[0]++;
            }
            return;
        }

        for (Edge neighbor : graph.get(current)) {
            int newWeight = currentWeight + neighbor.weight;
            dfs(graph, neighbor.to, target, K, pathCount, newWeight);
        }
    }
}
