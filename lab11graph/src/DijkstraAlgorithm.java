import java.util.*;

public class DijkstraAlgorithm {
    private static final int INFINITY = Integer.MAX_VALUE;

    static class Edge {
        int destination;
        int weight;

        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void dijkstra(List<Edge>[] graph, int start) {
        int numVertices = graph.length;
        int[] distances = new int[numVertices];
        Arrays.fill(distances, INFINITY);
        distances[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int vertex = currentNode.vertex;
            int distance = currentNode.distance;

            if (distance > distances[vertex]) {
                continue;
            }

            for (Edge edge : graph[vertex]) {
                int neighbor = edge.destination;
                int weight = edge.weight;

                if (distance + weight < distances[neighbor]) {
                    distances[neighbor] = distance + weight;
                    queue.offer(new Node(neighbor, distances[neighbor]));
                }
            }
        }

        printShortestPaths(distances);
    }

    private static void printShortestPaths(int[] distances) {
        int startVertex = 1;
       // System.out.println("Shortest paths from vertex " + startVertex + ":");
        for (int i = 1; i < distances.length; i++) {
            if (distances[i] == INFINITY) {
                System.out.print(-1+" ");
            } else {
                System.out.print( distances[i]+" ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        int[][] edges=new int[m][3];
        for (int i = 0; i <m ; i++) {
            edges[i][0]=input.nextInt();
            edges[i][1]=input.nextInt();
            edges[i][2]=input.nextInt();

        }

        int numVertices = Arrays.stream(edges).mapToInt(edge -> Math.max(edge[0], edge[1])).max().getAsInt() + 1;

        List<Edge>[] graph = new List[numVertices];
        for (int i = 0; i < numVertices; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int weight = edge[2];
            graph[x].add(new Edge(y, weight));
        }

        dijkstra(graph, 1);
    }

    static class Node implements Comparable<Node> {
        int vertex;
        int distance;

        public Node(int vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Integer.compare(distance, other.distance);
        }
    }
}
