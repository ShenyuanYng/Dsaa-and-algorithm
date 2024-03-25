import java.util.*;

class Graph {
    private int numStations;
    private List<List<Edge>> adjacencyList;

    public Graph(int numStations) {
        this.numStations = numStations;
        adjacencyList = new ArrayList<>(numStations + 1); // index 0 is not used
        for (int i = 0; i <= numStations; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int p, int q, int company) {
        adjacencyList.get(p).add(new Edge(q, company));
        adjacencyList.get(q).add(new Edge(p, company));
    }

    public int getNumStations() {
        return numStations;
    }

    public List<Edge> getAdjacentEdges(int station) {
        return adjacencyList.get(station);
    }
}

class Edge {
    private int destination;
    private int company;

    public Edge(int destination, int company) {
        this.destination = destination;
        this.company = company;
    }

    public int getDestination() {
        return destination;
    }

    public int getCompany() {
        return company;
    }
}

public class SubwayMinimumCost {
    private static final int INFINITY = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numStations = scanner.nextInt();
        int numLines = scanner.nextInt();

        Graph graph = new Graph(numStations);
        for (int i = 0; i < numLines; i++) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            int company = scanner.nextInt();
            graph.addEdge(p, q, company);
        }

        int minCost = dijkstra(graph);
        System.out.println(minCost);
    }

    private static int dijkstra(Graph graph) {
        int numStations = graph.getNumStations();
        int[] costs = new int[numStations + 1];
        Arrays.fill(costs, INFINITY);
        costs[1] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.cost));
        queue.offer(new Node(1, 0, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int station = current.station;
            int cost = current.cost;
            int company = current.company;

            if (cost > costs[station]) {
                continue;
            }

            List<Edge> adjacentEdges = graph.getAdjacentEdges(station);
            for (Edge edge : adjacentEdges) {
                int destination = edge.getDestination();
                int nextCost = cost + (edge.getCompany() == company ? 0 : 1);

                if (nextCost < costs[destination]) {
                    costs[destination] = nextCost;
                    queue.offer(new Node(destination, nextCost, edge.getCompany()));
                }
            }
        }

        return costs[numStations] == INFINITY ? -1 : costs[numStations];
    }

    static class Node {
        private int station;
        private int cost;
        private int company;

        public Node(int station, int cost, int company) {
            this.station = station;
            this.cost = cost;
            this.company = company;
        }
    }
}
