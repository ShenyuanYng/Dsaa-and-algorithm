import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graph {
    private int vertices; // 顶点数
    private List<List<Integer>> adjacencyList; // 邻接表

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    public boolean isTree() {
        boolean[] visited = new boolean[vertices];

        // 检测是否存在环
        if (isCyclic(0, visited, -1)) {
            return false;
        }

        // 检测是否所有顶点都被访问到
        for (int i = 0; i < vertices; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    private boolean isCyclic(int vertex, boolean[] visited, int parent) {
        visited[vertex] = true;

        List<Integer> neighbors = adjacencyList.get(vertex);
        for (Integer neighbor : neighbors) {
            if (!visited[neighbor]) {
                if (isCyclic(neighbor, visited, vertex)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n=input.nextInt();
        int m=input.nextInt();
        Graph graph = new Graph(n);
        for (int i = 0; i <m ; i++) {
            graph.addEdge(input.nextInt()-1, input.nextInt()-1);
        }

        if (graph.isTree()) {
            System.out.println("tree");
        } else {
            System.out.println("graph");
        }
    }
}
