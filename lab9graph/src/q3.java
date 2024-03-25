import java.util.*;

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph.get(x).add(y);
        }
        sc.close();
        int[] distances = bfs(graph, 0, n);
        for (int i = 1; i < n; i++) {
            if(n == n -1 ){
                System.out.print(distances[i]);

            }else{
                System.out.print(distances[i] + " ");

            }
        }

    }

    public static int[] bfs(List<List<Integer>> graph, int start, int n) {
        int[] distances = new int[n];
        Arrays.fill(distances, -1);
        distances[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : graph.get(currentNode)) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = distances[currentNode] + 1;
                    queue.add(neighbor);
                }
            }
        }
        return distances;
    }
}

