import java.util.*;

public class q4 {
    static List<Integer>[] graph;
    static int[] inDegree;
    static int[] maxIndex;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList[n + 1];
        inDegree = new int[n + 1];
        maxIndex = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[y].add(x); // Reverse the edges
            inDegree[x]++;
        }

        // Perform a reverse topological sort
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                maxIndex[i] = i;
            }
        }

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : graph[currentNode]) {
                maxIndex[neighbor] = Math.max(maxIndex[neighbor], maxIndex[currentNode]);
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Print the result
        for (int i = 1; i <= n; i++) {
            System.out.print(maxIndex[i] + " ");
        }
    }
}
