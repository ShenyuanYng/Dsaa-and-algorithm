import java.util.*;
/*
class Graph {
    private int V;
    private List<List<Integer>> adj;

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v) {
        adj.get(u).add(v);
    }

    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;

        for (int i : adj.get(v)) {
            if (!visited[i]) {
                DFSUtil(i, visited);
            }
        }
    }

    Graph getTranspose() {
        Graph transposedGraph = new Graph(V);

        for (int v = 0; v < V; v++) {
            for (int i : adj.get(v)) {
                transposedGraph.addEdge(i, v);
            }
        }

        return transposedGraph;
    }

    boolean isSCC() {
        boolean[] visited = new boolean[V];
        DFSUtil(0, visited);

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        Graph transposedGraph = getTranspose();
        visited = new boolean[V];
        transposedGraph.DFSUtil(0, visited);

        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }

        return true;
    }
}

public class SCC {
    public static void main(String[] args) {
        // 读取输入
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Graph graph = new Graph(n);
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;
            graph.addEdge(x, y);
        }

        // 检查是否是强连通分量
        boolean isSCC = graph.isSCC();

        // 输出结果
        if (isSCC) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}*/
