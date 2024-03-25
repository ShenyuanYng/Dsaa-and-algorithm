import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DirectedGraph {
    private int vertices; // 顶点数
    private List<List<Integer>> adjacencyList; // 邻接表

    public DirectedGraph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source - 1).add(destination - 1);
    }

    public int[] calculateMaxIndices() {
        int[] maxIndices = new int[vertices];
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                dfs(i, visited, maxIndices);
            }
        }

        return maxIndices;
    }

    private void dfs(int vertex, boolean[] visited, int[] maxIndices) {
        visited[vertex] = true;

        List<Integer> neighbors = adjacencyList.get(vertex);
        for (Integer neighbor : neighbors) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, maxIndices);
            }
            maxIndices[vertex] = Math.max(maxIndices[vertex], maxIndices[neighbor]);
        }

        maxIndices[vertex] = Math.max(maxIndices[vertex], vertex);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        DirectedGraph graph = new DirectedGraph(n);
        for (int i = 0; i < m; i++) {
            graph.addEdge(input.nextInt(), input.nextInt());
        }

        int[] maxIndices = graph.calculateMaxIndices();
        for (int i = 0; i < maxIndices.length; i++) {
            System.out.print( (maxIndices[i] + 1)+" ");
        }
    }
}
