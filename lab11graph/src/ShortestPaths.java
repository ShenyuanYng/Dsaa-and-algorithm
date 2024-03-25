import java.util.*;

public class ShortestPaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Number of nodes
        int m = scanner.nextInt(); // Number of edges

        // Create an adjacency list to represent the graph
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Read the edges and build the adjacency list
        for (int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            adjacencyList.get(x).add(y);
            adjacencyList.get(y).add(x);
        }

        // Calculate the shortest paths using BFS
        int[] shortestPaths = calculateShortestPaths(adjacencyList, n);

        // Print the total number of shortest paths from node 1 to each node
        for (int i = 2; i <= n; i++) {
            System.out.print(shortestPaths[i] + " ");
        }
    }

    private static int[] calculateShortestPaths(List<List<Integer>> adjacencyList, int n) {
        int[] shortestPaths = new int[n + 1];
        Arrays.fill(shortestPaths, 0);
        shortestPaths[1] = 1; // Starting node has 1 shortest path

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adjacencyList.get(node)) {
                if (shortestPaths[neighbor] == 0) {
                    shortestPaths[neighbor] = shortestPaths[node];
                    queue.offer(neighbor);
                } else if (shortestPaths[neighbor] == shortestPaths[node]) {
                    shortestPaths[neighbor]++;
                }
            }
        }

        return shortestPaths;
    }
}
