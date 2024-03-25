/*
import java.util.*;
/*
class Graph {
    private int V;
    private List<List<Edge>> adj;

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V + 1);
        for (int i = 0; i <= V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adj.get(source).add(edge);
    }

    public int shortestPath(int source, int destination) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        pq.offer(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;

            for (Edge edge : adj.get(u)) {
                int v = edge.destination;
                int weight = edge.weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }

        return dist[destination] != Integer.MAX_VALUE ? dist[destination] : -1;
    }

    private static class Edge {
        int source;
        int destination;
        int weight;

        public Edge(int source, int destination, int weight) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
        }
    }

    private static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }
}

public class ShortestPath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p = scanner.nextInt();

        Graph graph = new Graph(n);

        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int k = scanner.nextInt();
            graph.addEdge(x, y, k);
        }

        for (int i = 0; i < p; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int shortestPathLength = graph.shortestPath(u, v);
            if (shortestPathLength == -1) {
                System.out.println("impossible");
            } else {
                System.out.println( shortestPathLength);
            }
        }
    }
}
*/